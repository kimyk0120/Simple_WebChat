package com.toypwebchat.toyp_webchat.webchat.repository;

import com.toypwebchat.toyp_webchat.webchat.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<ChatMessage, String> {

}
