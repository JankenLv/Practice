package com.lvjing.oa.dao;

import com.lvjing.oa.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public interface EmployeeDao {
    void insert(Employee employee);

    void delete(String sn);

    void update(Employee employee);

    Employee selectById(String sn);

    List<Employee> selectAll();

    List<Employee> selectByDepartmentAndPost(@Param("dsn") String dsn, @Param("post") String post);
}