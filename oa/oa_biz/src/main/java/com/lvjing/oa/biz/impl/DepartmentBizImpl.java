package com.lvjing.oa.biz.impl;

import com.lvjing.oa.biz.DepartmentBiz;
import com.lvjing.oa.dao.DepartmentDao;
import com.lvjing.oa.entity.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("departmentBiz")
public class DepartmentBizImpl implements DepartmentBiz {

    @Resource
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void remove(String sn) {
        departmentDao.delete(sn);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public Department get(String sn) {
        return departmentDao.selectById(sn);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
