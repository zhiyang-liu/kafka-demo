package com.example.kafka2.controller;

import com.example.kafka2.service.KafkaReceiveService;
import com.example.kafka2.service.KafkaSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    @Autowired
    private KafkaSenderService kafkaSenderService;
    @RequestMapping(value = "/index")
    public String index() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            kafkaSenderService.send();
            Thread.sleep(1000);
        }
        return "success!!";
    }
}
