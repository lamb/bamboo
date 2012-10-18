package com.yonyou.bamboo.controller;

import java.security.NoSuchAlgorithmException;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.bamboo.model.User;
import com.yonyou.bamboo.service.UserService;
import com.yonyou.bamboo.util.Constants;
import com.yonyou.bamboo.util.CryptoUtil;

@Controller
public class SignController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseBody
    public String signin(@Valid User user, BindingResult result, HttpServletResponse response) throws NoSuchAlgorithmException {
        StringBuffer msg = new StringBuffer();
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                msg.append(error.getField() + error.getDefaultMessage());
            }
        } else {
            user.setPassword(CryptoUtil.digest(user.getPassword()));
            if (userService.verifyPassword(user.getEmail(), user.getPassword())) {
                Cookie cookie = new Cookie(Constants.COOKIE_SU, user.getEmail() + ":" + user.getPassword());
                cookie.setPath("/");
                cookie.setMaxAge(2 * 3600);
                response.addCookie(cookie);
                msg.append("登陆成功");
            }else {
                msg.append("登陆失败");
            }
        }
        return msg.toString();
    }

    @RequestMapping(value = "/cookie", method = RequestMethod.GET)
    @ResponseBody
    public String cookie(@CookieValue(value = "SU", required = false) String su) {
        return su;
    }

}
