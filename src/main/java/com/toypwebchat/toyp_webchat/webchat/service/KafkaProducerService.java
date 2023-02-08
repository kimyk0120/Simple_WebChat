package com.toypwebchat.toyp_webchat.webchat.service;

import com.toypwebchat.toyp_webchat.webchat.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {

    @Value("${kafka.topic.name}")
    private String TOPIC_NAME;

    private final KafkaTemplate<String, ChatMessage> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, ChatMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ChatMessage message) {
        log.info(">>>>>>>> kafka send message : " +  message);
        this.kafkaTemplate.send("webchat-topic", message);
    }
}
