package com.tapan.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.core.KafkaTemplate;

public interface KafkaService {


    boolean notifyService(String message) throws JsonProcessingException;
    boolean notifyService2(String message) throws JsonProcessingException;



}
