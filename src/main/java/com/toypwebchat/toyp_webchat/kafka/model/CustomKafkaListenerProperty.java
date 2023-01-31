package com.toypwebchat.toyp_webchat.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomKafkaListenerProperty {

    private String topic;
    private String listenerClass;
}