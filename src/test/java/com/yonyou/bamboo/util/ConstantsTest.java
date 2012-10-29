package com.yonyou.bamboo.util;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConstantsTest {

    public static final String BAMBOO_CONTEXT = "classpath:bamboo-context.xml";
    public static final String BAMBOO_SERVLET_CONTEXT = "classpath:bamboo-servlet-context.xml";

    @Test
    public void test() {
        new Constants();
        assertEquals("Bamboo", Constants.PROJECT_NAME);
    }

}
