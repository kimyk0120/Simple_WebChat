package com.toypwebchat.toyp_webchat.webchat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/chatRooms")
public class RoomController {

    /***
     * 채팅방 목록 페이지
      * @param request
     * @return
     */
    @GetMapping("")
    public String chatRooms(HttpServletRequest request) {
        return "content/chatRooms";
    }

    /***
     * 채팅방 페이지
     * @param request
     * @return
     */
    @GetMapping("/room")
    public String chatRoom(HttpServletRequest request) {
        return "content/chatRoom";
    }


}//.class
