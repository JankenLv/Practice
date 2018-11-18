package com.lvjing.hd.service.impl;

import com.lvjing.hd.dao.DepartmentDao;
import com.lvjing.hd.entity.Department;
import com.lvjing.hd.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        department.setCreateTime(new Date());
        department.setUpdateTime(new Date());
        departmentDao.insert(department);
    }

    public void remove(Integer id) {
        departmentDao.delete(id);
    }

    public void modify(Department department) {
        departmentDao.update(department);
    }

    public Department getById(Integer id) {
        return departmentDao.selectById(id);
    }

    public List<Department> getByCatId(Integer catId) {
        return departmentDao.selectByCatId(catId);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
