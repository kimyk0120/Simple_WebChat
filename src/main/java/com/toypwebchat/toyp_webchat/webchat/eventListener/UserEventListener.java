package com.toypwebchat.toyp_webchat.webchat.eventListener;

import com.toypwebchat.toyp_webchat.webchat.model.event.UserRegEvent;
import com.toypwebchat.toyp_webchat.webchat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserEventListener {

    private final UserService userService;


    public UserEventListener(UserService userService) {
        this.userService = userService;
    }

    @EventListener(UserRegEvent.class)
    public void onUserRegEvent(UserRegEvent event) {
        log.info("UserEventListener.onUserRegEvent");
        userService.setSessionAndCookie(event.getRequest(), event.getResponse(), event.getUser());
        userService.saveUser(event.getUser());
    }



}//.class
