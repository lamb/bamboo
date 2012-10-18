package com.yonyou.bamboo.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.yonyou.bamboo.model.User;
import com.yonyou.bamboo.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public String getPassword(String email) {
        return jdbcTemplate.queryForObject("select password from user where email=?", String.class, email);
    }

    @Override
    public User get(String email) {
        return jdbcTemplate.queryForObject("select * from user where email=?", User.class, email);
    }

    @Override
    public int save(User user) {
        String sql = "insert into user(username, password, email, salt) values(:username, :password, :email, :salt)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user), keyHolder);
        return keyHolder.getKey().intValue();
    }

}
