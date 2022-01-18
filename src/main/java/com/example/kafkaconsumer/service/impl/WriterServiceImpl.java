package com.example.kafkaconsumer.service.impl;

import com.example.kafkaconsumer.service.WriterService;
import com.example.kafkaconsumer.utils.GreetGenerator;
import com.example.schemas.WriterResponseSchema;
import com.example.schemas.WriterSchema;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@KafkaListener(groupId = "writerProcessor", topics = {"writer_generator_topic"},
        containerFactory = "writerListenerContainerFactory")
public class WriterServiceImpl implements WriterService {
    @Value("${topic.writer-response-topic}")
    private String topicResponse;
    private final RedisTemplate<String, Object> redisTemplate;
    private final KafkaTemplate<String, WriterResponseSchema> kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(WriterServiceImpl.class);

    @Override
    @KafkaHandler
    public void consumeWriter(WriterSchema record) {
        logger.info("--------------------------Writer KafkaHandler----------------------------");
        logger.info("record: " + record.toString());
        logger.info("record.getSchema(): " + record.getSchema());
        logger.info("group.id: " + KafkaUtils.getConsumerGroupId());
        logger.info("------------------------------------------------------------------------");

        buildProducerResponse(saveWriter(record));
    }

    @Override
    public Optional<WriterSchema> getPersistedWriter(String key) {
        var res = redisTemplate.opsForValue().get(key);
        if (res instanceof WriterSchema) {
            return Optional.of((WriterSchema) res);
        }
        return Optional.empty();
    }

    @Override
    public void updateRating(String writerId, double updatingValue) {
        getPersistedWriter(writerId).ifPresent(writerSchema -> {
            writerSchema.setRating(writerSchema.getRating() + updatingValue);
            saveWriter(writerSchema);
            buildProducerResponse(writerId);
        });
    }

    private String saveWriter(WriterSchema writerSchema) {
        logger.info("Writing " + writerSchema.getClass().getName() + " to Redis: " + writerSchema);
        redisTemplate.opsForValue().set(writerSchema.getNickname().toString(), writerSchema);
        return writerSchema.getNickname().toString();
    }

    private void buildProducerResponse(String key) {
        getPersistedWriter(key)
                .ifPresent(writerSchema -> {
                    String greetMsg = GreetGenerator.getGreet(writerSchema.getName() + " " + writerSchema.getSurname());
                    WriterResponseSchema writerResponseSchema = WriterResponseSchema.newBuilder()
                            .setWriter(writerSchema)
                            .setNickname(writerSchema.getNickname())
                            .setGreetMessage(greetMsg)
                            .build();

                    kafkaTemplate.send(topicResponse, writerResponseSchema)
                            .addCallback(
                                    res -> {
                                        logger.info("----------------SEND MSG--------------------");
                                        logger.info("topic: " + res.getRecordMetadata().topic());
                                        logger.info("partition: " + res.getRecordMetadata().partition());
                                        logger.info("data: " + res.getProducerRecord().toString());
                                        logger.info("offset: " + res.getRecordMetadata().offset());
                                        logger.info("---------------------------------------------");
                                    },
                                    err -> logger.error("ERROR while sending msg to KafkaProducer: ", err));
                });
    }
}
