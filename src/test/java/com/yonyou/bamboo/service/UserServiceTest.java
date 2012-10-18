package com.yonyou.bamboo.service;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class UserServiceTest {
    @Test
    public void testVerifyPassword() throws NoSuchAlgorithmException {
        new UserService().verifyPassword("","");
        assertTrue(true);
    }
}
