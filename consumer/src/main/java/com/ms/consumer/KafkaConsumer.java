package com.ms.consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {



    @KafkaListener(topics = "my_topic", groupId = "my_group_id")
    public void listen(ConsumerRecord<String, User> record) {
        User user = record.value();
        System.out.println("Received Message:");
        System.out.println("Key: " + record.key());
        System.out.println("User: " + user.getUsername() + ", " + user.getEmail());
        System.out.println("Partition: " + record.partition());
        System.out.println("Offset: " + record.offset());
        System.out.println("--------------------");
    }
}