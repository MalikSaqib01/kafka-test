package com.ms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public String sendMessageToKafkaTopic() {
        for (int i = 0; i < 10; i++) {
            String username = "Message " + i;
            User user = new User(username, "pass"+username);
        this.kafkaProducer.sendMessage(user);
    }
        return "Message sent to Kafka Topic";

    }
}
