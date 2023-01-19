package com.toypwebchat.toyp_webchat.webchat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

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
     * - 로그인 성공시 세션에 사용자 정보를 저장.
     * @param request
     * @param userName
     * @return
     */
    @PostMapping("/user")
    public @ResponseBody String user(HttpServletRequest request, @RequestParam Map userName) {
        log.info("userName : {}", userName);
        return "Succees";
    }


}
