package com.toypwebchat.toyp_webchat.webchat.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

    public static void createSession (String key, String value, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userId", value);
        session.setMaxInactiveInterval(60 * 10);
    }
}
