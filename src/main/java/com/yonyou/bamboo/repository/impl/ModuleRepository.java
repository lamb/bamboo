/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yonyou.bamboo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.yonyou.bamboo.model.Module;

/**
 * bamboo ModuleRepository
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-22
 * @since 
 */
@Repository
public class ModuleRepository {
	
	@Autowired JdbcTemplate jdbcTemplate;
	@Autowired NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public Long save(Module module) {
		String sql = "insert into module(project_id,name,create_by,create_date)" +
				" values(:projectId,:name,:createBy,:createDate)";
		KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(module), holder);
		return holder.getKey().longValue();
	}
	
	public Module get(long id) {
		String sql = "select * from module a where a.id=?";
		Module m = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Module>(Module.class), id);
		return m;
	}
	
	public List<Module> findAll() {
		String sql = "select * from module";
		List<Module> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Module>(Module.class));
		return list;
	}
	
	public List<Module> findByProject(long projectId) {
		String sql = "select * from module a where a.project_id=?";
		List<Module> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Module>(Module.class), projectId);
		return list;
	}
	
	public void update(Module module) {
		String sql = "update module set project_id=:projectId,name=:name" +
				",modify_by=:modifyBy,modify_date=:modifyDate where id=:id";
		namedJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(module));
	}
	
	public void delete(Module module) {
		deleteById(module.getId());
	}
	
	public void deleteById(long id) {
		String sql = "delete from module where id=?";
		jdbcTemplate.update(sql, id);
	}
}
