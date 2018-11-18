package com.imooc.sbm.webapp.mapper;

import com.imooc.sbm.webapp.bean.Staff;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StaffMapper {

    @Select("select * from sm.staff")
    @ResultType(com.imooc.sbm.webapp.bean.Staff.class)
    List<Staff> selectAll();

    void insert(Staff staff);

}
