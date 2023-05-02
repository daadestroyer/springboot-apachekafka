package com.daadestroyer.springbootapachekafka.kafka;

import com.daadestroyer.springbootapachekafka.payload.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "thecoderstv_json", groupId = "group1")
    public void consume(User user){
        LOGGER.info(String.format("Consumer Json message recieved -> %s", user.toString()));
    }
}
