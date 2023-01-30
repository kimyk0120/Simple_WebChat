package com.toypwebchat.toyp_webchat.webchat.controller;

import com.toypwebchat.toyp_webchat.webchat.common.dto.BasicResponse;
import com.toypwebchat.toyp_webchat.webchat.model.Room;
import com.toypwebchat.toyp_webchat.webchat.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/chatRooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    /***
     * 채팅방 목록 페이지 VIEW
      * @param request
     * @return
     */
    @GetMapping("")
    public String chatRooms(HttpServletRequest request) {
        return "content/chatRooms";
    }

    /***
     * 채팅방 페이지 VIEW
     * @param request
     * @return
     */
    @GetMapping("/room")
    public String chatRoom(HttpServletRequest request) {
        return "content/chatRoom";
    }


    /***
     * 채팅방 목록 조회
     * @param request
     * @return
     */
    @GetMapping("/getRooms")
    public @ResponseBody List<Room> getRooms(HttpServletRequest request) {
        return roomService.getRooms();
    }


    /***
     * 채팅방 생성
     * @param request
     * @return
     */
    @PostMapping("/createRoom")
    public @ResponseBody ResponseEntity<? extends BasicResponse> createRoom(HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}//.class
