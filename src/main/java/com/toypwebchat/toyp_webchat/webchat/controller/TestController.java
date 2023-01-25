package com.toypwebchat.toyp_webchat.webchat.controller;


import com.toypwebchat.toyp_webchat.webchat.model.Room;
import com.toypwebchat.toyp_webchat.webchat.model.User;
import com.toypwebchat.toyp_webchat.webchat.service.RoomService;
import com.toypwebchat.toyp_webchat.webchat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {

    private final RoomService roomService;
    private final UserService userService;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private String port;

    public TestController(RoomService roomService, UserService userService) {
        this.roomService = roomService;
        this.userService = userService;
    }

    @RequestMapping("")
    public @ResponseBody String test() {
        return "test";
    }

    @RequestMapping("getprops")
    public @ResponseBody String getprops() {
        log.info("### host : " + host);
        log.info("### port : " + port);
        return "test";
    }

    @RequestMapping("getrooms")
    public @ResponseBody List<Room> getrooms() {
        return roomService.getRooms();
    }

    @RequestMapping("getusers")
    public @ResponseBody List<User> getusers() {
        return userService.getUsers();

    }

}
