package com.toypwebchat.toyp_webchat.webchat.service;


import com.toypwebchat.toyp_webchat.webchat.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChatService {

    private final SimpMessagingTemplate template;

    private final RoomService roomService;

    private final KafkaProducerService kafkaProducerService;

    public ChatService(SimpMessagingTemplate template, RoomService roomService, KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
        this.template = template;
        this.roomService = roomService;
    }

    public void sendMessage(ChatMessage message) {
        kafkaProducerService.sendMessage(message);
        template.convertAndSend("/subscribe/chat/room/" + message.getRoomId(), message);
    }

    public void leave(ChatMessage message) {
        kafkaProducerService.sendMessage(message);
        roomService.leaveRoom(message.getRoomId());
        template.convertAndSend("/subscribe/chat/room/" + message.getRoomId(), message);
    }

    public void join(ChatMessage message) {
        kafkaProducerService.sendMessage(message);
        template.convertAndSend("/subscribe/chat/room/" + message.getRoomId(), message);
    }
}
