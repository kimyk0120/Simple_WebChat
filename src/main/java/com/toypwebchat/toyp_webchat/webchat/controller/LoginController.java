package com.toypwebchat.toyp_webchat.webchat.controller;

import com.toypwebchat.toyp_webchat.webchat.common.dto.BasicResponse;
import com.toypwebchat.toyp_webchat.webchat.model.User;
import com.toypwebchat.toyp_webchat.webchat.model.event.UserRegEvent;
import com.toypwebchat.toyp_webchat.webchat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    private final ApplicationEventPublisher applicationEventPublisher;

    public LoginController(UserService userService, ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
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
    public ResponseEntity<? extends BasicResponse> user(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
        // userId 생성
        user.setUserId(String.valueOf(UUID.randomUUID()));
        log.info("login user Name :  "  + user.getUserName());
        log.info("user Id : " + user.getUserId());

        UserRegEvent userRegEvent = new UserRegEvent(user, request, response);
        applicationEventPublisher.publishEvent(userRegEvent);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}
