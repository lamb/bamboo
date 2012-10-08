package com.yonyou.bamboo.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    public boolean verifyPassword(String email, String password) {
        System.out.println("verify");
        return email.equals(password);
    }

}
