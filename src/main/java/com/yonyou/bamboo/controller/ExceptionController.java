package com.yonyou.bamboo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @RequestMapping("/exception")
    public @ResponseBody String exception() {
        throw new IllegalStateException("Sorry!");
    }
    
    @ExceptionHandler
    public @ResponseBody String handle(IllegalStateException e) {
        return "IllegalStateException handled!";
    }

}