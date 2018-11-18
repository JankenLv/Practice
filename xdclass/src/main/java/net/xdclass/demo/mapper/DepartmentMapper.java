package net.xdclass.demo.mapper;

import net.xdclass.demo.bean.Department;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 部门接口
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/10 15:02 </p>
 */
@Repository
public interface DepartmentMapper {

    @Select("select * from department")
    @ResultType(Department.class)
    List<Department> selectAllDepartment();
}
