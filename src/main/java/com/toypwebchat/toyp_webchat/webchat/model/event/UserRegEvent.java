package com.toypwebchat.toyp_webchat.webchat.model.event;

import com.toypwebchat.toyp_webchat.webchat.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Getter
@Setter
@ToString
public class UserRegEvent extends ApplicationEvent {

    private final User user;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public UserRegEvent(User user, HttpServletRequest request, HttpServletResponse response) {
        super(user);
        this.user = user;
        this.request = request;
        this.response = response;
    }
}