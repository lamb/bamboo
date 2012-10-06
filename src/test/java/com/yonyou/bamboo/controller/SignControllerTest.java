package com.yonyou.bamboo.controller;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import com.yonyou.bamboo.model.User;

public class SignControllerTest {

    @Test
    public void testSignin() {
        ApplicationContext context = new ClassPathXmlApplicationContext("../WEB-INF/spring-mvc-servlet.xml");
        SignController controller = context.getBean(SignController.class);
        // SignController controller = new SignController();
        User user = new User();
        user.setEmail("email#email.com");
        user.setPassword("password");
        BindingResult result = new BeanPropertyBindingResult(user, user.getClass().getName());
        controller.signin(user, null, result);
        fail("Not yet implemented");
    }

    @Test
    public void testCookie() {
        SignController controller = new SignController();
        String su = null;
        controller.cookie(su);
        fail("Not yet implemented");
    }

}
