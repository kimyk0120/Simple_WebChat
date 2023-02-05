package com.toypwebchat.toyp_webchat.webchat.controller;


import com.toypwebchat.toyp_webchat.webchat.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ChatController {

    private final SimpMessagingTemplate template;

    public ChatController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/chat/join")
    public void join(ChatMessage message) {
        log.info("MessageMapping /chat/join");
        message.setMessage(message.getSenderName() + "님이 입장하셨습니다.");
        template.convertAndSend("/subscribe/chat/room/" + message.getRoomId(), message);
    }

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        log.info("MessageMapping /chat/message");
        template.convertAndSend("/subscribe/chat/room/" + message.getRoomId(), message);
    }

}
