package com.yonyou.bamboo.controller;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import com.yonyou.bamboo.util.ConstantsTest;

public class SignControllerTest {

    private MockMvc mvc;

    @Before
    public void SetUp() {
        mvc = MockMvcBuilders.xmlConfigSetup(ConstantsTest.BAMBOO_CONTEXT, ConstantsTest.BAMBOO_SERVLET_CONTEXT).build();
    }

    @Test
    public void testSignin() throws Exception {
        mvc.perform(post("/signin").param("email", "email@email.com").param("password", "password")).andExpect(status().isOk()).andExpect(redirectedUrl("/"));
        mvc.perform(post("/signin").param("email", "email@email.com").param("password", "email@email.com")).andExpect(status().isOk()).andExpect(redirectedUrl("/"));
    }

    @Test
    public void testSigninValid() throws Exception {
        MockMvc m = standaloneSetup(new SignController()).build();
        m.perform(post("/signin").param("email", "email@email.com")).andExpect(status().isOk()).andExpect(model().attributeHasFieldErrors("user", "password"));
    }

    @Test
    public void testCookie() throws Exception {
        mvc.perform(get("/cookie")).andExpect(status().isOk()).andExpect(redirectedUrl("/"));
    }

}
