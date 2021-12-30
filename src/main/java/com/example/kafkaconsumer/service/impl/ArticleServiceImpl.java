package com.example.kafkaconsumer.service.impl;

import com.example.kafkaconsumer.service.ArticleService;
import com.example.kafkaconsumer.service.WriterService;
import com.example.kafkaconsumer.utils.TextCharacteristicsCounter;
import com.example.schemas.ArticleResponseSchema;
import com.example.schemas.ArticleSchema;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@KafkaListener(groupId = "articleProcessor", topicPartitions = {@TopicPartition(topic = "article_generator_topic", partitions = {"0"})},
//        containerFactory = "articleListenerContainerFactory")
@KafkaListener(groupId = "articleProcessor", topics = {"article_generator_topic"},
        containerFactory = "articleListenerContainerFactory")
public class ArticleServiceImpl implements ArticleService {
    @Value("${topic.article-response-topic}")
    private String topicResponse;
    private static final String ARTICLE_TABLE = "Article";

    private final RedisTemplate<String, Object> redisTemplate;
    private final WriterService writerService;
    private final KafkaTemplate<String, ArticleResponseSchema> kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
    private HashOperations<String, String, ArticleSchema> hashOps;

    @PostConstruct
    public void initHashOps() {
        hashOps = redisTemplate.opsForHash();
    }

    @Override
    @KafkaHandler
    public void consumeArticle(ArticleSchema record) {
        logger.info("namespace: " + record.getSchema().getNamespace());
        String key = save(record);
        if (key != null) {
            writerService.updateRating(record.getWriterNickname().toString(), TextCharacteristicsCounter.countWords(record.getText().toString()));
            buildProducerResponse(key);
        }
    }

    @Override
    public Optional<ArticleSchema> getPersistedArticle(String key) {
        var res = hashOps.get(ARTICLE_TABLE, key);
        if (res != null) {
            return Optional.of(res);
        }
        return Optional.empty();
    }

    private String save(ArticleSchema articleSchema) {
        if (hashOps.get(ARTICLE_TABLE, articleSchema.getUniqueArticleName()) == null) {
            logger.info("Put ArticleSchema instance into storage: " + articleSchema);
            hashOps.put(ARTICLE_TABLE, articleSchema.getUniqueArticleName().toString(), articleSchema);
            return articleSchema.getUniqueArticleName().toString();
        }
        return null;
    }

    private void buildProducerResponse(String key) {
        getPersistedArticle(key).ifPresent(articleSchema -> {
            ArticleResponseSchema articleResponseSchema = ArticleResponseSchema.newBuilder()
                    .setCharactersWithSpaces(articleSchema.getText().length())
                    .setSpaces(TextCharacteristicsCounter.countSpaces(articleSchema.getText().toString()))
                    .setArticle(articleSchema)
                    .setWords(TextCharacteristicsCounter.countWords(articleSchema.getText().toString()))
                    .build();

            kafkaTemplate.send(topicResponse, articleResponseSchema)
                    .addCallback(res -> logger.info(res.getProducerRecord().toString()),
                            err -> logger.error(err.getMessage()));
        });
    }
}
