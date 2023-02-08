package com.toypwebchat.toyp_webchat.webchat.controller;


import com.toypwebchat.toyp_webchat.webchat.common.dto.BasicResponse;
import com.toypwebchat.toyp_webchat.webchat.model.ChatMessage;
import com.toypwebchat.toyp_webchat.webchat.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        chatService.join(message);
    }

    @MessageMapping("/chat/leave")
    public void leave(ChatMessage message) {
        log.info("MessageMapping /chat/leave");
        message.setMessage(message.getSenderId() + "님이 퇴장하셨습니다.");
        chatService.leave(message);
    }

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        log.info("MessageMapping /chat/message");
        chatService.sendMessage(message);
    }

    @RequestMapping(value = "/chat/message" , produces = "application/json", method = {RequestMethod.POST})
    public ResponseEntity<? extends BasicResponse> messagePost(@RequestBody ChatMessage message) {
        log.info("MessageMapping /chat/message");
        chatService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
