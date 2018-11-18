package com.lvjing.oa.biz;

import com.lvjing.oa.entity.Department;

import java.util.List;

public interface DepartmentBiz {
    void add(Department department);

    void remove(String sn);

    void edit(Department department);

    Department get(String sn);

    List<Department> getAll();
}
