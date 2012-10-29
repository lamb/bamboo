package com.yonyou.bamboo.model;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void testUser() {
        user.getId();
        user.getEmail();
        user.getPassword();
        user.getUsername();
        user.getSalt();
        user.setId(1);
        user.setEmail("111");
        user.setPassword("111");
        user.setUsername("username");
        user.setSalt(74328);
    }

}
