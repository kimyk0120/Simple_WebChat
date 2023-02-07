package com.toypwebchat.toyp_webchat.webchat.repository;

import com.toypwebchat.toyp_webchat.webchat.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
    Room findByRoomId(String roomId);


    void deleteByRoomId(String roomId);

}
