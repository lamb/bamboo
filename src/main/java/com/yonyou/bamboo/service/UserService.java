package com.yonyou.bamboo.service;

import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            User user = userRepository.get(email);
            if (null != user) {
                password = CryptoUtil.digest(password + user.getSalt());
                if (password.equals(user.getPassword())) {
                    flag = true;
                }
            }
        } catch (EmptyResultDataAccessException e) {
        }
        return flag;
    }

    @Transactional
    public int save(User user) throws NoSuchAlgorithmException {
        Random random = new Random();
        user.setSalt(random.nextInt(99999));
        user.setPassword(CryptoUtil.digest(user.getPassword()));
        user.setPassword(CryptoUtil.digest(user.getPassword() + user.getSalt()));
        user.setUsername("yonyou");
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User get(String email) {
        return userRepository.get(email);
    }

}
