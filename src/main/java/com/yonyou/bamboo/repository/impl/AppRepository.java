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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yonyou.bamboo.model.AppConfiguration;
import com.yonyou.bamboo.repository.IAppRepository;

/**
 * bamboo AppRepository
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-16
 * @since 
 */
@Repository
public class AppRepository implements IAppRepository {

	private static final String SQL = "SELECT a.appTitle,a.appHost,a.adminEmail,a.appOwner FROM app_configuration a LIMIT 1";
	
	@Autowired private JdbcTemplate jdbc;
	
	/* (non-Javadoc)
	 * @see com.yonyou.bamboo.repository.IAppRepository#getConfig()
	 */
	@Override
	public AppConfiguration getConfig() {
		AppConfiguration config = jdbc.queryForObject(SQL, new BeanPropertyRowMapper<AppConfiguration>(AppConfiguration.class));
		return config;
	}

}
