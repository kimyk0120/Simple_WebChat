package com.toypwebchat.toyp_webchat.webchat.service;

import com.toypwebchat.toyp_webchat.webchat.common.utils.CookieUtils;
import com.toypwebchat.toyp_webchat.webchat.common.utils.SessionUtils;
import com.toypwebchat.toyp_webchat.webchat.model.User;
import com.toypwebchat.toyp_webchat.webchat.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setSessionAndCookie(HttpServletRequest request, HttpServletResponse response, User user) {
        SessionUtils.createSession("userId", user.getUserId(), request);
        response.addCookie(CookieUtils.createCookie("userId", user.getUserId(), request));
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

}
