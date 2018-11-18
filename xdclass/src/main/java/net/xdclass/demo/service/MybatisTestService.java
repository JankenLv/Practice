package net.xdclass.demo.service;

import net.xdclass.demo.bean.Department;
import net.xdclass.demo.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 测试Mybatis与SpringBoot整合
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/10 15:06 </p>
 */
@Service
public class MybatisTestService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 获取所有部门信息
     *
     * @return
     */
    public List<Department> listDepartment() {
        return departmentMapper.selectAllDepartment();
    }

}
