package com.example.kafkaconsumer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaResponseTopicConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${topic.article-response-topic}")
    private String articleResponseTopic;
    @Value("${topic.writer-response-topic}")
    private String writerResponseTopic;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic articleResponseTopic() {
        return new NewTopic(articleResponseTopic, 2, (short) 1);
    }

    @Bean
    public NewTopic writerResponseTopic() {
        return new NewTopic(writerResponseTopic, 2, (short) 1);
    }
}
