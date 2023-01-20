package com.toypwebchat.toyp_webchat.webchat.controller;

import com.toypwebchat.toyp_webchat.webchat.model.User;
import com.toypwebchat.toyp_webchat.webchat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /***
     * 로그인 페이지
     * @param request
     */
    @GetMapping("")
    public String login(HttpServletRequest request) {
        return "content/login";
    }


    /***
     * 로그인 처리
     * @param response
     * @param user
     * @return
     */
    @PostMapping("/user")
    public @ResponseBody String user(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
        // userId 생성
        log.info(user.getUserName());
        user.setUserId(String.valueOf(UUID.randomUUID()));

        userService.setSessionAndCookie(request, response, user);

        return "Succees";
    }


}
