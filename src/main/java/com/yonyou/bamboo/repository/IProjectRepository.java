package com.yonyou.bamboo.repository;

import java.util.List;

import com.yonyou.bamboo.model.Project;

public interface IProjectRepository {

    public List<Project> query(Project project, Class<Project> type);

    public int save(Project project);

    public Project queryForObject(Project project, Class<Project> type);

    public int update(Project where, Project project);

    public int delete(Project project);

}
