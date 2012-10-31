package com.yonyou.bamboo.repository;

import com.yonyou.bamboo.model.User;

public interface IUserRepository {

    String getPassword(String email);

    User get(String email);

    int getSalt(String email);

    int save(User user);

}
