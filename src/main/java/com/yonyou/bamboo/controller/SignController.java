package com.yonyou.bamboo.controller;

import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.yonyou.bamboo.model.User;
import com.yonyou.bamboo.service.UserService;

@Controller
public class SignController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(@Valid User user, BindingResult result, HttpServletResponse response) {
        // TODO 前端页面验证
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getField() + error.getDefaultMessage());
            }
        } else {
            // TODO 登录后Cookie Session
            if (userService.verifyPassword(user.getEmail(), user.getPassword())) {
                Cookie cookie = new Cookie("SU", user.getEmail() + ":" + user.getPassword());
                cookie.setPath("/");
                cookie.setMaxAge(2 * 3600);
                response.addCookie(cookie);
            } else {
                return "redirect:/";
            }
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/cookie", method = RequestMethod.GET)
    public String cookie(@CookieValue(value = "SU", required = false) String su) {
        return "redirect:/";
    }
}
