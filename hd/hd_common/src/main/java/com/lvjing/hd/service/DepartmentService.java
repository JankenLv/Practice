package com.lvjing.hd.service;

import com.lvjing.hd.entity.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);

    void remove(Integer id);

    void modify(Department department);

    Department getById(Integer id);

    List<Department> getByCatId(Integer id);

    List<Department> getAll();
}
