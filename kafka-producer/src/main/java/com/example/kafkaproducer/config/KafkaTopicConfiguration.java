package com.example.kafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfiguration {

    @Value("${spring.kafka.app-topic.name}")
    private String topicName;

    @Value("${spring.kafka.app-topic.number-partitions}")
    private Integer partitions;

    @Value("${spring.kafka.app-topic.replication-factor}")
    private Short replicationFactor;

    @Bean
    public NewTopic topic() {
        return new NewTopic(topicName, partitions, replicationFactor);
    }

}
