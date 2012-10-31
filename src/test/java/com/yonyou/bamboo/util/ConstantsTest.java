package com.yonyou.bamboo.util;

import static org.junit.Assert.*;
import org.junit.Test;
import com.yonyou.bamboo.model.User;

public class ConstantsTest {

    public static final String BAMBOO_CONTEXT = "classpath:bamboo-context.xml";
    public static final String BAMBOO_SERVLET_CONTEXT = "classpath:bamboo-servlet-context.xml";
    public static final String WEB_ROOT = "src/main/webapp";
    public static final User USER = new User();

    static {
        USER.setId(-1);
        USER.setEmail("test@email.com");
        USER.setUsername("test");
    }

    @Test
    public void test() {
        //new Constants();
        assertEquals("Bamboo", Constants.PROJECT_NAME);
    }

}
