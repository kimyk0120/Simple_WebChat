package com.toypwebchat.toyp_webchat.webchat.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "message")
public class Message {
    private String message;
    private String sender;
    private String roomId;
    private Date time = new Date(System.currentTimeMillis());
}
