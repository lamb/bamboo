package com.yonyou.bamboo.util;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConstantsTest {

    @Test
    public void test() {
        new Constants();
        assertEquals("Bamboo", Constants.PROJECT_NAME);
    }

}
