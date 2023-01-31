package com.toypwebchat.toyp_webchat.webchat.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "room")
public class Room {

    private String roomId;
    private String roomName;

    private String topicName;

    private int userCount = 0;

    private Date createdAt = new Date(System.currentTimeMillis());
    private Date updatedAt = new Date(System.currentTimeMillis());

    public Room(String roomId, String roomName, String topicName) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.topicName = topicName;
    }

}
