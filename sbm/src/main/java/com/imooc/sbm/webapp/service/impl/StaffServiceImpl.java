package com.imooc.sbm.webapp.service.impl;

import com.imooc.sbm.webapp.bean.Staff;
import com.imooc.sbm.webapp.mapper.StaffMapper;
import com.imooc.sbm.webapp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<Staff> getAllStaff() {
        return staffMapper.selectAll();
    }

    @Override
    @Transactional
    public void add(Staff staff) {
//        staffMapper.insert(staff);
        staff.setAccount("小红");
        staff.setPassword("123456");
        staff.setStatus("离职");
        staffMapper.insert(staff);
//        int i = 1/0;
        staffMapper.insert(staff);
    }
}
