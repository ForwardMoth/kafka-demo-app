package com.example.kafkaproducer.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SuccessResponse implements Serializable {

    private String status = "Message sent successfully";

    private LocalDateTime timestamp = LocalDateTime.now();

}
