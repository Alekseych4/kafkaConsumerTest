package com.example.kafkaconsumer.config;

import com.example.schemas.ArticleSchema;
import com.example.schemas.WriterSchema;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${topic.schema.registry.url}")
    private String schemaRegistryUrl;

    @Bean(name = "writerConsumerFactory")
    public ConsumerFactory<String, WriterSchema> writerConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(configProperties("writerProcessor"));
    }

    @Bean(name = "writerListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, WriterSchema> writerListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, WriterSchema> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(writerConsumerFactory());
        factory.setConcurrency(3);
        return factory;
    }

    @Bean(name = "articleConsumerFactory")
    public ConsumerFactory<String, ArticleSchema> articleConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(configProperties("articleProcessor"));
    }

    @Bean(name = "articleListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, ArticleSchema> articleListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ArticleSchema> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(articleConsumerFactory());
        factory.setConcurrency(3);
        return factory;
    }

    private Map<String, Object> configProperties(String groupId) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        props.put("schema.registry.url", schemaRegistryUrl);

        return props;
    }
}
