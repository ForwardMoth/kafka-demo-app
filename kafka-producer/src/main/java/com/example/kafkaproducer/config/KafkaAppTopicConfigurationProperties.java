package com.example.kafkaproducer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.kafka.app-topic")
public class KafkaAppTopicConfigurationProperties {

    private String topicName;

    private Integer numberPartitions;

    private Short replicationFactor;

}
