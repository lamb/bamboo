package com.yonyou.bamboo.controller;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import com.yonyou.bamboo.util.ConstantsTest;

public class ProjectControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.xmlConfigSetup(ConstantsTest.BAMBOO_CONTEXT, ConstantsTest.BAMBOO_SERVLET_CONTEXT).build();
    }

    @Test
    public void testList() throws Exception {
        // TODO 自动化测试
        mvc.perform(get("/project")).andExpect(status().isOk()).andExpect(model().attributeExists("projects"));
    }

    @Test
    public void testShow() {
        fail("Not yet implemented");
    }

    @Test
    public void testCreate() {
        fail("Not yet implemented");
    }

    @Test
    public void testCreateProjectBindingResultUser() {
        fail("Not yet implemented");
    }

    @Test
    public void testModifyIntProjectModel() {
        fail("Not yet implemented");
    }

    @Test
    public void testModifyIntProjectBindingResultUser() {
        fail("Not yet implemented");
    }

    @Test
    public void testDelete() {
        fail("Not yet implemented");
    }

}
