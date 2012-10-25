package com.yonyou.bamboo.jdbc;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yonyou.bamboo.model.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bamboo-context.xml")
public class TemplateTest {

    @Autowired
    private Template template;

    @Test
    public void testTemplate() {
        fail("Not yet implemented");
    }

    @Test
    public void testTemplateDataSource() {
        fail("Not yet implemented");
    }

    @Test
    public void testTemplateDataSourceBoolean() {
        fail("Not yet implemented");
    }

    @Test
    public void testInitNamedJdbcTemplate() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateStringSqlParameterSourceKeyHolder() {
        fail("Not yet implemented");
    }

    @Test
    public void testInsert() throws Exception {
        Project project = new Project();
        project.setName("中文");
        project.setAbbr("ZHONGWEN");
        project.setModifyBy(-1);
        template.insert(project);
    }

}
