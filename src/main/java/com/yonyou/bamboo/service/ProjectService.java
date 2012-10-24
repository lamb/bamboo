package com.yonyou.bamboo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yonyou.bamboo.model.Project;
import com.yonyou.bamboo.repository.IProjectRepository;

@Service
public class ProjectService {

    @Autowired
    IProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public List<Project> list() {
        return projectRepository.list();
    }

}
