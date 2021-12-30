package com.example.kafkaconsumer.config;

import com.example.schemas.ArticleResponseSchema;
import com.example.schemas.WriterResponseSchema;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfig {
    @Value("${topic.schema.registry.url}")
    private String schemaRegistryUrl;
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ProducerFactory<?, ?> producerFactory() {

        Map<String, Object> configProps = new HashMap<>();

        configProps.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        configProps.put("schema.registry.url", schemaRegistryUrl);

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, WriterResponseSchema> writerResponseSchemaKafkaTemplate(
            ProducerFactory<String, WriterResponseSchema> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public KafkaTemplate<String, ArticleResponseSchema> articleResponseSchemaKafkaTemplate(
            ProducerFactory<String, ArticleResponseSchema> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
