package com.yonyou.bamboo.util;

import org.junit.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StringTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        String s = "中文";
        String t = URLEncoder.encode(s,"utf-8");
        System.out.println(t);
        s = "test \u4e2d\u56fd";
        System.out.println(s);
        StringBuilder sb = new StringBuilder();
        for(char ch : "test 中文".toCharArray()) {
            if(ch > 128) {
                sb.append("\\u"+Integer.toHexString(ch));
                System.out.print("\\u"+Integer.toHexString(ch)+";");
            } else {
                sb.append(ch);
                System.out.print(ch);
            }
        }
        System.out.println();
        System.out.println(sb);
        System.out.println((char)Integer.parseInt("4e2d", 16));
    }

}
