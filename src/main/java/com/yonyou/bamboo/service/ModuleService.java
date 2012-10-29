package com.yonyou.bamboo.service;

import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.bamboo.model.Module;
import com.yonyou.bamboo.repository.impl.ModuleRepository;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public int save(Module module) {
        return moduleRepository.save(module);
    }

    public Module get(int id) {
        return moduleRepository.get(id);
    }

    public List<Module> findByProject(int projectId) {
        return moduleRepository.findByProject(projectId);
    }

    public void modify(Module module) {
        module.setModifyDate(Calendar.getInstance().getTime());
        moduleRepository.update(module);
    }

    public void deleteById(int id) {
        moduleRepository.deleteById(id);
    }
}
