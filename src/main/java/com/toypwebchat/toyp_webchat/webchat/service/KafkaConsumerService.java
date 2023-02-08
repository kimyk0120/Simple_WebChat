package com.toypwebchat.toyp_webchat.webchat.service;

import com.toypwebchat.toyp_webchat.webchat.model.ChatMessage;
import com.toypwebchat.toyp_webchat.webchat.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {


    private final MessageRepository messageRepository;

    public KafkaConsumerService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @KafkaListener(topics = "webchat-topic", groupId = "webchat")
    public void consume(ChatMessage message) throws Exception {
        System.out.println("kafka consume receive message : " + message);
        messageRepository.save(message);
        //this.template.convertAndSend("/subscribe/chat/room/" + message.getRoomId(), message);
    }
}
