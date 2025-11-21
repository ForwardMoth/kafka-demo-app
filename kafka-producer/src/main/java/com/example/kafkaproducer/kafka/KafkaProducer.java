package com.example.kafkaproducer.kafka;

import com.example.kafkaproducer.config.KafkaAppTopicConfigurationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaAppTopicConfigurationProperties properties;

    public void sendMessage(String message) {
        log.info("sending message: {}", message);
        kafkaTemplate.send(properties.getTopicName(), message);
    }

}
