package com.yonyou.bamboo.interceptor;

import static org.junit.Assert.*;
import org.junit.Test;

public class SigninInterceptorTest {

    @Test
    public void testPreHandleHttpServletRequestHttpServletResponseObject() throws Exception {
        //TODO 这个怎么测，有待研究；还有TestNG比Junit好用？有空试试
        new SigninInterceptor().preHandle(null, null, null);
        fail("Not yet implemented");
    }

}
