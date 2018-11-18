package com.imooc.sbm.webapp.service;

import com.imooc.sbm.webapp.bean.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> getAllStaff();

    void add(Staff staff);
}
