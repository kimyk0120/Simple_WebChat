package com.toypwebchat.toyp_webchat.webchat.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "room")
public class Room {

    @MongoId
    private String roomId;
    private String roomName;

    private int userCount = 0;

    private Date createdAt = new Date(System.currentTimeMillis());
    private Date updatedAt = new Date(System.currentTimeMillis());

    public Room(String roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
    }

}
