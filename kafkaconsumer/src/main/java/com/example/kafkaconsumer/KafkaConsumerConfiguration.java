package com.example.kafkaconsumer;

import com.example.avro.Test;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

import java.util.HashMap;
import java.util.Map;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
public class KafkaConsumerConfiguration {

    //kafka consumer configuration for the test-martijn topic consuming messages op type avro
//    @Bean
//    public ConsumerFactory<String, Test> consumerFactory()
//    {
//        // Creating a Map of string-object pairs
////        Map<String, Object> config = new HashMap<>();
////
////        // Adding the Configuration
////        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
////                   "127.0.0.1:29092");
////        config.put(ConsumerConfig.GROUP_ID_CONFIG,
////                   "group_id");
////        config.put(
////                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
////                StringDeserializer.class);
////        // avro deserializer
////        config.put(
////                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
////                KafkaAvroDeserializer.class);
//
////        config.put("schema.registry.url", "http://localhost:8081");
////        config.put("specific.avro.reader", "true");
//
//        return new DefaultKafkaConsumerFactory<>(config);
//    }

    // Creating a Listener
//    public ConcurrentKafkaListenerContainerFactory concurrentKafkaListenerContainerFactory()
//    {
//        ConcurrentKafkaListenerContainerFactory<
//                        String, Test> factory
//                = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
}

