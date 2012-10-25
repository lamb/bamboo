package com.yonyou.bamboo.jdbc;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

public class Template extends JdbcTemplate {

    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public Template() {
        super();
    }

    public Template(DataSource dataSource) {
        super(dataSource);
        initNamedJdbcTemplate();
    }

    public Template(DataSource dataSource, boolean lazyInit) {
        super(dataSource, lazyInit);
        initNamedJdbcTemplate();
    }

    public void initNamedJdbcTemplate() {
        this.namedJdbcTemplate = new NamedParameterJdbcTemplate(this);
    }

    public int update(String sql, SqlParameterSource paramSource, KeyHolder generatedKeyHolder) throws DataAccessException {
        return namedJdbcTemplate.update(sql, paramSource, generatedKeyHolder);
    }

}
