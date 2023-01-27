package com.toypwebchat.toyp_webchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ToypWebChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToypWebChatApplication.class, args);
    }

}
