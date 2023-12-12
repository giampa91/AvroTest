package com.services.kafkaAvroProdCons.service;

import com.prepwork.kreadwritemsg.kafka.avro.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KfkaProducerService {

    @Autowired
    private KafkaTemplate<String, Student> kafkaTemplate;

    public void sendAvroData(String topicName, Student student) {
        String key = "Key" + String.format("%.3f", Math.random());
        kafkaTemplate.send(topicName, key, student);
    }

}
