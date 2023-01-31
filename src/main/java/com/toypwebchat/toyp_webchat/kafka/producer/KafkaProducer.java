package com.toypwebchat.toyp_webchat.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {


    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        System.out.printf("Produce message : %s%n", message);
        //(name=f5985830-fd76-4ed9-94b1-f4c3157e5467, topicId=CxKmVatkQRWxJUQ9TKcIOg, internal=false)
        this.kafkaTemplate.send("f5985830-fd76-4ed9-94b1-f4c3157e5467", message);
    }
}
