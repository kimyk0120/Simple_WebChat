package com.toypwebchat.toyp_webchat.webchat.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {

    public static Cookie createCookie(String name, String value, HttpServletRequest request) {
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain(request.getRequestURI().replace(request.getRequestURI(), ""));
        cookie.setPath("/");
        cookie.setMaxAge(-1);
        return cookie;
    }

    public static String getCookie(HttpServletRequest request, String name) {
        String value = "";
        Cookie[] list = request.getCookies();
        for(Cookie cookie:list) {
            if(cookie.getName().equals(name)) {
                value = cookie.getValue();
            }
        }
        return value;
    }
}
