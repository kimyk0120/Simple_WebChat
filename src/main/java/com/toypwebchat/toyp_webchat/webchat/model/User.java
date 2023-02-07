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
@Document(collection = "user")
public class User {
    private String userName;

    @MongoId
    private String userId;

    private Date createdAt = new Date(System.currentTimeMillis());
    private Date updatedAt = new Date(System.currentTimeMillis());


}
