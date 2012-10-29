package com.yonyou.bamboo.model;

import org.junit.Before;
import org.junit.Test;

public class InviteTest {
    private Invite invite;

    @Before
    public void setUp() throws Exception {
        invite = new Invite();
    }

    @Test
    public void testInvite() {
        invite.getId();
        invite.getNo();
        invite.getEmail();
        invite.getStatus();

        invite.setId(1);
        invite.setNo("no");
        invite.setEmail("ss");
        invite.setStatus(1);
    }

}
