package com.toypwebchat.toyp_webchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableKafka
@SpringBootApplication
@EnableAsync
@ConfigurationPropertiesScan
public class ToypWebChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToypWebChatApplication.class, args);
    }

}
