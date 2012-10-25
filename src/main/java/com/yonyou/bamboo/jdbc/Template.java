package com.yonyou.bamboo.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class Template extends NamedParameterJdbcTemplate {

    public Template(DataSource dataSource) {
        super(dataSource);
    }

}
