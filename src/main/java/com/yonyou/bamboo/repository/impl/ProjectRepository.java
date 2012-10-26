package com.yonyou.bamboo.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.yonyou.bamboo.jdbc.Template;
import com.yonyou.bamboo.model.Project;
import com.yonyou.bamboo.repository.IProjectRepository;

@Repository
public class ProjectRepository implements IProjectRepository {

    @Autowired
    Template template;

    @Override
    public List<Project> list() {
        return template.query("select * from project", new BeanPropertyRowMapper<Project>(Project.class));
    }

    @Override
    public int save(Project project) {
        return template.insert(project);
    }

    @Override
    public Project query(int id) {
        return template.queryForObject("select * from project where id=?", new BeanPropertyRowMapper<Project>(Project.class), id);
    }

    @Override
    public int update(Project project) {
        String sql = "update project set name = ?, abbr = ?, modify_by = ?, modify_date = now() where id = ?";
        return template.update(sql, project.getName(), project.getAbbr(), project.getModifyBy(), project.getId());
    }

    @Override
    public int delete(Project project) {
        String sql = "delete from project where id = ?";
        return template.update(sql, project.getId());
    }
}
