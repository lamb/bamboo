package com.yonyou.bamboo.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yonyou.bamboo.model.User;
import com.yonyou.bamboo.repository.IUserRepository;
import com.yonyou.bamboo.util.CryptoUtil;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    @Transactional(readOnly = true)
    public boolean verifyPassword(String email, String password) throws NoSuchAlgorithmException {
        boolean flag = false;
        //TODO 先查询数量=1
        User user = userRepository.get(email);
        if (null != user) {
            password = CryptoUtil.digest(password + user.getSalt());
            if (password.equals(user.getPassword())) {
                flag = true;
            }
        }
        return flag;
    }

    @Transactional
    public int save(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User get(String email) {
        return userRepository.get(email);
    }

}
