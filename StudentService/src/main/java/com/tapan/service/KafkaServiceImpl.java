package com.tapan.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaServiceImpl implements KafkaService {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;



    public boolean notifyService(String message) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        String msg=mapper.writeValueAsString(message);
        this.kafkaTemplate.send("studentChannel",msg);
        return true;
    }

    @Override
    public boolean notifyService2(String message) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(message);
        this.kafkaTemplate.send("channel2",json);
        return false;
    }
}
