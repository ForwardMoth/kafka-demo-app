package com.example.kafkaproducer.controller;

import com.example.kafkaproducer.dto.SuccessResponse;
import com.example.kafkaproducer.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/send")
    public ResponseEntity<SuccessResponse> kafkaSendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse());
    }

}
