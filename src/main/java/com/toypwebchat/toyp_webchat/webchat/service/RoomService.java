package com.toypwebchat.toyp_webchat.webchat.service;

import com.toypwebchat.toyp_webchat.kafka.admiinClient.KafkaAdminClient;
import com.toypwebchat.toyp_webchat.webchat.model.Room;
import com.toypwebchat.toyp_webchat.webchat.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository, KafkaAdminClient kafkaAdminClient) {
        this.roomRepository = roomRepository;
    }

    public Room createRoom(String roomName) {
        String roomId = UUID.randomUUID().toString();
        try {
            Room room = new Room();
            room.setRoomId(roomId);
            room.setRoomName(roomName);
            roomRepository.save(room);
            return room;
        } catch (Exception e) {
            log.error("Error while creating room", e);
        }
        return null;
    }

    public void saveRoom(Room room) {

        roomRepository.save(room);
    }


    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    public Room getRoom(String roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    public void updateRoom(Room room) {
        roomRepository.save(room);
    }
    public void deleteRoom(String roomId) {
        roomRepository.deleteById(roomId);
    }



}//.class
