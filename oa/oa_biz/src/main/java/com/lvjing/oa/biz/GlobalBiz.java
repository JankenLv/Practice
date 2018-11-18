package com.lvjing.oa.biz;

import com.lvjing.oa.entity.Employee;

public interface GlobalBiz {
    Employee login(String sn, String password);

    void changePassword(Employee employee);
}
