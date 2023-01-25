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
    private String name;

    private Topic topic;

    private Date createdAt = new Date(System.currentTimeMillis());
    private Date updatedAt = new Date(System.currentTimeMillis());

    public Room(String roomId, String name, Topic topic) {
        this.roomId = roomId;
        this.name = name;
        this.topic = topic;
    }

}
