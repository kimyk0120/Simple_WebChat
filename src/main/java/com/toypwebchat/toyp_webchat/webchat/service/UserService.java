package com.toypwebchat.toyp_webchat.webchat.service;

import com.toypwebchat.toyp_webchat.webchat.common.utils.CookieUtils;
import com.toypwebchat.toyp_webchat.webchat.common.utils.SessionUtils;
import com.toypwebchat.toyp_webchat.webchat.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@Slf4j
public class UserService {

    public void setSessionAndCookie(HttpServletRequest request, HttpServletResponse response, User user) {
        SessionUtils.createSession("userId", user.getUserId(), request);
        response.addCookie(CookieUtils.createCookie("userId", user.getUserId(), request));
    }
}
