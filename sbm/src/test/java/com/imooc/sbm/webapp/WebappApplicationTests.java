package com.imooc.sbm.webapp;

import com.imooc.sbm.webapp.bean.Staff;
import com.imooc.sbm.webapp.mapper.StaffMapper;
import com.imooc.sbm.webapp.service.StaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebappApplicationTests {

    @Autowired
    private StaffService staffService;

    @Test
    public void contextLoads() {
        float f = (float) 3.4;
        System.out.println(2>>3);
    }

    @Test
    public void testDatabase() {
        /*Staff staff = new Staff();
        staff.setAccount("小红");
        staff.setPassword("123456");
        staff.setStatus("离职");
        staffMapper.insert(staff);
        int i = 1/0;
        staffMapper.insert(staff);
        System.out.println(staff.getId());*/
        staffService.add(new Staff());

    }

}
