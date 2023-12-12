package com.services.kafkaAvroProdCons.consumer;

import com.prepwork.kreadwritemsg.kafka.avro.model.Student;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KfkaConsumer {

    @KafkaListener(topics = "student-data",
            groupId = "group_id",
            containerFactory = "myAvroConsumerFactory")
    public void listen(ConsumerRecord<String, Student> consumerRecord, Acknowledgment acknowledgment){
String key = consumerRecord.key();
        Student value = consumerRecord.value();
        acknowledgment.acknowledge();
    }

}
