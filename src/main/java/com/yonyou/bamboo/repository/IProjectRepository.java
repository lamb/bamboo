package com.yonyou.bamboo.repository;

import java.util.List;

import com.yonyou.bamboo.model.Project;

public interface IProjectRepository {

    public List<Project> list();

    public int save(Project project);

    public Project query(int id);

    public int update(Project project);

    public int delete(Project project);

}
