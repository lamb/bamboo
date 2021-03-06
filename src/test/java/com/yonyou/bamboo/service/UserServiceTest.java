package com.yonyou.bamboo.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.security.NoSuchAlgorithmException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yonyou.bamboo.model.User;
import com.yonyou.bamboo.util.ConstantsTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(ConstantsTest.BAMBOO_CONTEXT)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
    }

    @Test
    public void testVerifyPassword() throws NoSuchAlgorithmException {
        assertThat(userService.verifyPassword("", ""), is(false));
    }

    @Test
    public void testSave() throws NoSuchAlgorithmException {
        // TODO咋测试
        User user = new User();
        user.setEmail("gaoyang_auto@yonyou.com");
        user.setPassword("123456");
        // int id = userService.save(user);
        // System.out.println("id=" + id);
    }
}
