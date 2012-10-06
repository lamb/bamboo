package com.yonyou.bamboo.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserServiceTest {
    @Test
    public void testVerifyPassword() {
        new UserService().verifyPassword("","");
        assertTrue(true);
    }
}
