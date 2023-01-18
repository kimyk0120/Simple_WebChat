package com.toypwebchat.toyp_webchat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping(value = "/1", method= RequestMethod.GET)
    public String index(HttpServletRequest request) {
        log.info("index");
        return "TemplatesIndex";
    }

    @RequestMapping(value = "/2", method= RequestMethod.GET)
    public ModelAndView test2(HttpServletRequest request) {
        log.info("test2");
        ModelAndView modelAndView = new ModelAndView("content/test");

        Map<String, Object> info = new HashMap<>();
        info.put("name", "kim");
        info.put("age", 29);

        List<String> datas = new ArrayList<>();
        datas.add("red");
        datas.add("orange");
        datas.add("yellow");

        modelAndView.addObject("info", info);
        modelAndView.addObject("datas", datas);

        return modelAndView;
    }






}

