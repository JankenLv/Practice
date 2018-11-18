package com.lvjing.oa.dao;

import com.lvjing.oa.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);

    void delete(String sn);

    void update(Department department);

    Department selectById(String sn);

    List<Department> selectAll();
}
