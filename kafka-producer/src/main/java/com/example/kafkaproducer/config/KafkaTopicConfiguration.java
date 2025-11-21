package com.example.kafkaproducer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class KafkaTopicConfiguration {

    private final KafkaAppTopicConfigurationProperties properties;

    @Bean
    public NewTopic topic() {
        return new NewTopic(
                properties.getTopicName(),
                properties.getNumberPartitions(),
                properties.getReplicationFactor()
        );
    }

}
