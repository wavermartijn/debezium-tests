package com.example.kafkaconsumer;

import com.example.avro.Test;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(id = "myId", topics = "users")
    public void consume(@Payload ConsumerRecord<String, Test> record, ConsumerRecordMetadata meta, Acknowledgment ack){
        Test test = record.value();
        System.out.println("Consumed message: " + test.getName()+ " and partition: " + meta.partition()+" and offset: " + meta.offset());
        ack.acknowledge();
    }
}