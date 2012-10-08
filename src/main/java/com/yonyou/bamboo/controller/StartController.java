package com.yonyou.bamboo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartController {

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String start() {
        System.out.println("start");
        return "start";
    }
    
}