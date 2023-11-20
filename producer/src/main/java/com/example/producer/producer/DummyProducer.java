package com.example.producer.producer;

import com.example.avro.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DummyProducer {

    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, Test> kafkaTemplate;


    int count = 0;

    @Scheduled(fixedRate = 10_000)
    public void schedule(){
        log.info("Sending message");


//        Message<Test> message = MessageBuilder.withPayload(Test.newBuilder().setAge(12).setName("Martijn").build())
//                .build();
//        kafkaTemplate.send(TOPIC, String.format("Hello %s World", count++));
        kafkaTemplate.send(TOPIC, Test.newBuilder().setAge(12).setName(String.format("Martijn %s", count++)).build());

    }
}
