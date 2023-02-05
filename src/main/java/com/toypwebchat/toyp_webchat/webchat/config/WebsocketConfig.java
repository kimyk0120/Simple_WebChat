package com.toypwebchat.toyp_webchat.webchat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // broker 역할 수행시 사용할 prefix
        registry.enableSimpleBroker("/subscribe", "/topic");
        registry.setApplicationDestinationPrefixes("/app"); // 메세지 수신 용 prefix
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        registry
                .addEndpoint("/stomp")
                .setAllowedOrigins("*")
                .withSockJS()
                .setStreamBytesLimit(512 * 1024)
                .setHttpMessageCacheSize(1000)
                .setDisconnectDelay(30 * 1000);

        registry.addEndpoint("/websocket");
        registry.addEndpoint("/websocket").setAllowedOrigins("*").withSockJS();
    }

}
