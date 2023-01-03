package com.toypwebchat.toyp_webchat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class TestController {

    @RequestMapping(value = "/test", method= RequestMethod.GET)
    public String index(HttpServletRequest request) {
        log.info("index");
        return "TemplatesIndex";
    }


    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public String goHome(HttpServletRequest request) {
        log.info("goHome");
        return "content/test";
    }

}
