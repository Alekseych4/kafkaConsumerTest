package com.example.kafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerApplication {
    private final static String topic = "test6";

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }

//    @Bean
//    public NewTopic topic() {
//        return TopicBuilder.name("topic1")
//                .partitions(10)
//                .replicas(1)
//                .build();
//    }

//    @KafkaListener(groupId = "group1", topicPartitions = {@TopicPartition(topic = topic, partitions = {"0"})})
//    public void listen(ConsumerRecord<String, WriterSchema> consumerRecord) {
//        System.out.println(consumerRecord.value().toString());
//    }

}
