package com.daadestroyer.springbootapachekafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic theCodersTVTopic(){
        return TopicBuilder.name("thecoderstv").build();
    }

    @Bean
    public NewTopic theCodersTVJsonTopic(){
        return TopicBuilder.name("thecoderstv_json").build();
    }

}
