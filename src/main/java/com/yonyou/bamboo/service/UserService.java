package com.yonyou.bamboo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.bamboo.model.User;
import com.yonyou.bamboo.repository.IUserRepository;

@Service
public class UserService {
	@Autowired IUserRepository userRepository;
    public boolean verifyPassword(String email, String password) {
        System.out.println("verify");
        return email.equals(password);
    }
    
    public void saveUser(User user) {
    	// some thing
    }

}
