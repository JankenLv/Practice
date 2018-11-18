package com.imooc.sbm.webapp.fastJson;

import com.imooc.sbm.webapp.bean.JsonResult;
import com.imooc.sbm.webapp.bean.User;
import org.junit.Test;

public class TestFastJson {

    @Test
    public void test() {

        User user = new User();
        user.setName("小红");
        user.setPassword("12456");

        System.out.println(JsonResult.render(user));
    }

}
