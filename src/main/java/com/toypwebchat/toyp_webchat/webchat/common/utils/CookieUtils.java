package com.toypwebchat.toyp_webchat.webchat.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {

    public static Cookie createCookie(String name, String value, HttpServletRequest request) {
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain(request.getRequestURI().replace(request.getRequestURI(), ""));
        //cookie.setPath("/");
        cookie.setMaxAge(60 * 10);
        return cookie;
    }

    public String getCookie(HttpServletRequest request, String name) {
        String value = null;
        Cookie[] list = request.getCookies();
        for(Cookie cookie:list) {
            if(cookie.getName().equals(name)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
