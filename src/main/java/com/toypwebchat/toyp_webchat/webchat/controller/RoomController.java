package com.toypwebchat.toyp_webchat.webchat.controller;

import com.toypwebchat.toyp_webchat.webchat.common.utils.CookieUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/")
public class RoomController {

    /***
     * 채팅방 목록 페이지
      * @param request
     * @return
     */
    @GetMapping("chatRooms")
    public String chatRooms(HttpServletRequest request) {
        String value = CookieUtils.getCookie(request, "userId");
        log.info("value : {}", value);
        log.info("########");
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
