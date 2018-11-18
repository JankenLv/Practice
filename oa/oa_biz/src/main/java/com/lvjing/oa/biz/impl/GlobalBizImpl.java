package com.lvjing.oa.biz.impl;

import com.lvjing.oa.biz.GlobalBiz;
import com.lvjing.oa.dao.EmployeeDao;
import com.lvjing.oa.entity.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("globalBiz")
public class GlobalBizImpl implements GlobalBiz {

    @Resource
    private EmployeeDao employeeDao;

    public Employee login(String sn, String password) {
        Employee employee = employeeDao.selectById(sn);
        if (employee != null && employee.getPassword().equals(password)) {
            return employee;
        }
        return null;
    }

    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
