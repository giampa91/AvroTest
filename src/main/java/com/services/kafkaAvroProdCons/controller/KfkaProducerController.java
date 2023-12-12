package com.services.kafkaAvroProdCons.controller;

import com.prepwork.kreadwritemsg.kafka.avro.model.Student;
import com.services.kafkaAvroProdCons.service.KfkaProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class KfkaProducerController {

    @Value("${avro.topic.name}")
    private String avroTopicName;

    @Autowired
    private KfkaProducerService producerService;

    @PostMapping("/createStudent")
    public String getDataForKafkaTopic(@RequestBody Student student){
        producerService.sendAvroData(avroTopicName, student);
        return "Data Posted";
    }


}
