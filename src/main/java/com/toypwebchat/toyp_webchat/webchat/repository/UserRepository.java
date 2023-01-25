package com.toypwebchat.toyp_webchat.webchat.repository;

import com.toypwebchat.toyp_webchat.webchat.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByUserName(String userName);
}
