package com.toypwebchat.toyp_webchat.webchat.controller;


import com.toypwebchat.toyp_webchat.webchat.model.ChatMessage;
import com.toypwebchat.toyp_webchat.webchat.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/chat/join")
    public void join(ChatMessage message) {
        log.info("MessageMapping /chat/join");
        message.setMessage(message.getSenderId() + "님이 입장하셨습니다.");
        chatService.sendMessage(message);
    }

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        log.info("MessageMapping /chat/message");
        chatService.sendMessage(message);
    }

}
