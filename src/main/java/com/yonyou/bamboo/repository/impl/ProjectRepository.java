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
import com.yonyou.bamboo.model.Project;
import com.yonyou.bamboo.repository.IProjectRepository;

@Repository
public class ProjectRepository implements IProjectRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public List<Project> list() {
        return jdbcTemplate.query("select * from project", new BeanPropertyRowMapper<Project>(Project.class));
    }

    @Override
    public int save(Project project) {
        String sql = "insert into project(name, abbr, create_by, create_date) values(:name, :abbr, :createBy, now())";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(project), keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public Project query(int id) {
        return jdbcTemplate.queryForObject("select * from project where id=?", new BeanPropertyRowMapper<Project>(Project.class), id);
    }

    @Override
    public int update(Project project) {
        String sql = "update project set name = ?, abbr = ?, modify_by = ?, modify_date = now() where id = ?";
        return jdbcTemplate.update(sql, project.getName(), project.getAbbr(), project.getModifyBy(), project.getId());
    }

    @Override
    public int delete(Project project) {
        String sql = "delete from project where id = ?";
        return jdbcTemplate.update(sql, project.getId());
    }
}
