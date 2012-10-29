package com.yonyou.bamboo.repository.impl;

import java.util.Calendar;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.yonyou.bamboo.model.Module;

public class ModuleRepositoryTest {

    @Autowired
    private ModuleRepository moduleRepository;

    @Test
    public void testSave() {
        Module m = new Module();
        m.setName("xx模块");
        m.setProjectId(1);
        m.setCreateBy(2);
        m.setCreateDate(Calendar.getInstance().getTime());
        int id = moduleRepository.save(m);
        Assert.notNull(id);
    }

    @Test
    public void testGet() {
        Module m = moduleRepository.get(1);
        Assert.notNull(m);
    }

    @Test
    public void testFindAll() {
        List<Module> list = moduleRepository.findAll();
        Assert.notEmpty(list);
    }

    @Test
    public void testFindByProject() {
        List<Module> list = moduleRepository.findByProject(1);
        Assert.notEmpty(list);
    }

    @Test
    public void testUpdate() {
        Module m = new Module();
        m.setName("xx模块");
        m.setProjectId(1);
        m.setCreateBy(2);
        m.setCreateDate(Calendar.getInstance().getTime());
        moduleRepository.update(m);
    }

    @Test
    public void testDelete() {
        Module m = new Module();
        moduleRepository.delete(m);
    }

    @Test
    public void testdeleteById() {
        moduleRepository.deleteById(1);
    }
}
