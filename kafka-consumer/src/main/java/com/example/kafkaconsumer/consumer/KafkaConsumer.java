package com.example.kafkaconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.app-topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listener(String message) {
        log.info("Received message: {}", message);
    }

}
