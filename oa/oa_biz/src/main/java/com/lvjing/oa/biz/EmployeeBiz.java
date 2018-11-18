package com.lvjing.oa.biz;

import com.lvjing.oa.entity.Employee;

import java.util.List;

public interface EmployeeBiz {
    Employee add(Employee employee);

    void remove(String sn);

    Employee edit(Employee employee);

    Employee get(String sn);

    List<Employee> getAll();

    List<Employee> updateAll();
}
