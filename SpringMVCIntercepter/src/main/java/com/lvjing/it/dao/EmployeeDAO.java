package com.lvjing.it.dao;

import com.lvjing.it.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 持久层
 */
@Repository
public class EmployeeDAO {
    private Map<Integer, Employee> employees = new HashMap<>();

    /**
     * 新增员工
     * @param employee 员工信息
     */
    public void insert(Employee employee) {
        employees.put(employee.getId(),employee);
    }

    /**
     * 删除员工
     * @param id 员工ID
     */
    public void delete(Integer id) {
        employees.remove(id);
    }

    /**
     * 修改员工信息
     * @param employee 员工信息
     */
    public void update(Employee employee) {
        employees.put(employee.getId(),employee);
    }

    /**
     * 通过ID查找员工
     * @param id 员工ID
     * @return 员工信息
     */
    public Employee selectById(Integer id) {
        return employees.get(id);
    }

    /**
     * 查找所有员工信息
     * @return 所有员工信息
     */
    public Collection<Employee> selectAll() {
        return employees.values();
    }
}
