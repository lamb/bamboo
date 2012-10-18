package com.yonyou.bamboo.repository;

import com.yonyou.bamboo.model.User;

public interface IUserRepository {

    public String getPassword(String email);

    public User get(String email);
    
    public int save(User user);

}
