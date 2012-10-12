package com.yonyou.bamboo.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.yonyou.bamboo.model.Invite;
import com.yonyou.bamboo.repository.IInviteRepository;

@Repository
public class InviteRepository implements IInviteRepository {

	@Autowired JdbcTemplate jdbcTemplate;
	@Autowired NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public void save(String email, String no) {
		String sql = "insert into invite(email, no) values(?,?)";
		jdbcTemplate.update(sql, email, no);
	}
	
	public int save(Invite invite) {
		String sql = "insert into invite(email, no) values(:email, :no)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(invite), keyHolder);
		return keyHolder.getKey().intValue();
	}
}
