package com.yonyou.bamboo.jdbc;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import java.util.Date;
import java.util.List;
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
    public void testQuery() throws Exception {
        Project project = new Project();
        List<Project> projects = template.query(project, Project.class);
        assertThat(projects.size() >= 0, is(true));
        System.out.println(projects.size());
    }

    @Test
    public void testQueryForObject() throws Exception {
        Project project = new Project();
        assertNull(template.queryForObject(project, Project.class));
        project.setId(1);
        assertNotNull(template.queryForObject(project, Project.class));
        project.setId(99999999);
        assertNull(template.queryForObject(project, Project.class));
    }

    @Test
    public void testInsert() throws Exception {
        Project project = new Project();
        project.setName("中文");
        project.setAbbr("ZHONGWEN");
        project.setModifyBy(-1);
        project.setModifyDate(new Date());
        // template.insert(project);
    }

    @Test
    public void testDelete() throws Exception {
        Project project = new Project();
        project.setId(999999);
        assertThat(template.delete(project), is(0));
    }

    @Test
    public void testUpdate() throws Exception {
        Project where = new Project();
        where.setId(999999);
        Project project = new Project();
        project.setAbbr("aa");
        assertThat(template.update(where, project), is(0));
    }
}
