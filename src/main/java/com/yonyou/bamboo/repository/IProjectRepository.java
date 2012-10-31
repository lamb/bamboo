package com.yonyou.bamboo.repository;

import java.util.List;

import com.yonyou.bamboo.model.Project;

public interface IProjectRepository {

    List<Project> query(Project project, Class<Project> type);

    int save(Project project);

    Project queryForObject(Project project, Class<Project> type);

    int update(Project where, Project project);

    int delete(Project project);

}
