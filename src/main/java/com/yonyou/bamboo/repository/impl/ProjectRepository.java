package com.yonyou.bamboo.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.yonyou.bamboo.jdbc.Template;
import com.yonyou.bamboo.model.Project;
import com.yonyou.bamboo.repository.IProjectRepository;

@Repository
public class ProjectRepository implements IProjectRepository {

    @Autowired
    Template template;

    @Override
    public List<Project> query(Project project, Class<Project> type) {
        return template.query(project, type);
    }

    @Override
    public int save(Project project) {
        return template.insert(project);
    }

    @Override
    public Project queryForObject(Project project, Class<Project> type) {
        return template.queryForObject(project, type);
    }

    @Override
    public int update(Project project) {
        String sql = "update project set name = ?, abbr = ?, modify_by = ?, modify_date = now() where id = ?";
        return template.update(sql, project.getName(), project.getAbbr(), project.getModifyBy(), project.getId());
    }

    @Override
    public int delete(Project project) {
        return template.delete(project);
    }
}
