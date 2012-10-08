package com.yonyou.bamboo.controller;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;
import org.junit.Test;

public class ExceptionControllerTest {

    @Test
    public void testException() throws Exception {
        standaloneSetup(new ExceptionController()).build().perform(get("/exception")).andExpect(status().isOk()).andExpect(content().string("IllegalStateException handled!"));
    }

}
