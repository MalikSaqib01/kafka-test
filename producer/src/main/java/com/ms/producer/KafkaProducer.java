package com.ms.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC = "my_topic";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;





    public void sendMessage(User user) {
        this.kafkaTemplate.send(TOPIC, user.getUsername() , user);
    }
}