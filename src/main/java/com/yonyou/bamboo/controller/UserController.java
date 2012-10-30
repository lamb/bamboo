package com.yonyou.bamboo.controller;

import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.yonyou.bamboo.model.User;
import com.yonyou.bamboo.service.InviteService;
import com.yonyou.bamboo.service.UserService;

@Controller
@RequestMapping("/u")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private InviteService inviteService;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView regist(User user) {

        return null;
    }

    @RequestMapping(value = "/invite", method = RequestMethod.POST)
    public ModelAndView inviteRegist(User user, @RequestParam("inviteNo") String inviteNo) throws NoSuchAlgorithmException {
        user.setEmail(inviteService.findEmailByInviteNo(inviteNo));
        userService.save(user);
        return new ModelAndView("message");
    }

}
