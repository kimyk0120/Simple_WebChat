package com.toypwebchat.toyp_webchat.webchat.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private String port;

    @RequestMapping("")
    public @ResponseBody String test() {
        return "test";
    }

    @RequestMapping("getprops")
    public @ResponseBody String getprops() {
        log.info("### host : " + host);
        log.info("### port : " + port);
        return "test";
    }

}
