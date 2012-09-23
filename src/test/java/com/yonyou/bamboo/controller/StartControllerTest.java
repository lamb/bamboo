package com.yonyou.bamboo.controller;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartControllerTest {

    @Test
    public void testStart() {
        StartController controller = new StartController();
        assertEquals("start", controller.start());
        assertThat(3 > 2, is(true));
    }

}
