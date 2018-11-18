package com.lvjing.oa.biz.impl;

import com.lvjing.oa.biz.EmployeeBiz;
import com.lvjing.oa.dao.EmployeeDao;
import com.lvjing.oa.entity.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("employeeBiz")
public class EmployeeBizImpl implements EmployeeBiz {

    @Resource
    private EmployeeDao employeeDao;

    public Employee add(Employee employee) {
        employee.setPassword("000000");
        employeeDao.insert(employee);
        return get(employee.getSn());
    }

    public void remove(String sn) {
        employeeDao.delete(sn);
    }

    public Employee edit(Employee employee) {
        employeeDao.update(employee);
        return get(employee.getSn());
    }

    public Employee get(String sn) {
        return employeeDao.selectById(sn);
    }

    public List<Employee> getAll() {
        return employeeDao.selectAll();
    }

    public List<Employee> updateAll() {
        return employeeDao.selectAll();
    }
}
