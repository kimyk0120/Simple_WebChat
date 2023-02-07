package com.toypwebchat.toyp_webchat.webchat.service;



import com.toypwebchat.toyp_webchat.webchat.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChatService {

    @Value("${kafka.topic.name}")
    private String TOPIC_NAME;

    private final KafkaTemplate<String, ChatMessage> kafkaTemplate;

    private final SimpMessagingTemplate template;

    public ChatService(KafkaTemplate<String, ChatMessage> kafkaTemplate, SimpMessagingTemplate template) {
        this.kafkaTemplate = kafkaTemplate;
        this.template = template;
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "webchat")
    public void consume(ChatMessage message) {
        log.info("ChatService Consumed message : " + message);
        template.convertAndSend("/subscribe/chat/room/" + message.getRoomId(), message);
    }

    public void sendMessage(ChatMessage message) {
        this.kafkaTemplate.send(TOPIC_NAME, message);
    }
}
