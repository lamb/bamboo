package com.yonyou.bamboo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @RequestMapping("/exception")
    public String exception() {
        throw new IllegalStateException("Sorry!");
    }

    @ExceptionHandler
    @ResponseBody
    public String handle(IllegalStateException e) {
        return "IllegalStateException handled!";
    }

}