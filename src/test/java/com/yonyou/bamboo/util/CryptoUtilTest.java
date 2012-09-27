package com.yonyou.bamboo.util;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class CryptoUtilTest {

    @Test
    public void testDigest() throws NoSuchAlgorithmException {
        assertEquals("bf9661defa3daecacfde5bde0214c4a439351d4d", CryptoUtil.digest("sss"));
    }
    
    @Test
    public void testByte2hex() throws NoSuchAlgorithmException {
        new CryptoUtil();
        assertEquals("", CryptoUtil.byte2hex(null));
    }
    

}
