package com.yonyou.bamboo.loader;

import com.yonyou.bamboo.util.ConstantsTest;

public class WebContextLoader extends GenericWebContextLoader {

    public WebContextLoader() {
        super(ConstantsTest.WEB_ROOT, false);
    }

}
