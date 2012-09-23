package com.yonyou.bamboo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartController {

    @RequestMapping(value = "/start/{date}", method = RequestMethod.GET)
    public String start(@PathVariable("date") Date date) {
        System.out.println("working!~~~~~~~~~~~~~~~~~");
        System.out.println(date);
        return "start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public void start() {
        System.out.println("start");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

}