package com.toypwebchat.toyp_webchat.webchat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class LoginController {

    /***
     * 로그인 페이지
     * @param request
     */
    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        return "content/login";
    }
}
