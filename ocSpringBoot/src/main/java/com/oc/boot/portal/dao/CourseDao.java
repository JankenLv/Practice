package com.oc.boot.portal.dao;

import com.oc.boot.portal.bean.Course;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseDao")
public interface CourseDao {

    @Select("SELECT * FROM ocdb.t_course where free = #{free}")
    @ResultType(com.oc.boot.portal.bean.Course.class)
    List<Course> selectByFree(Integer free);
}
