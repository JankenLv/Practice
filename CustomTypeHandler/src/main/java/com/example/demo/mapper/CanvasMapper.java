package com.example.demo.mapper;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CanvasMapper {

    @Select("select count(1) from canvas where id = #{id}")
    @ResultType(Boolean.class)
    Boolean checkBooleanOfOneRow(Integer id);

    @Select("select 1 from canvas where name = #{name}")
    @ResultType(Boolean.class)
    Boolean checkBooleanOfMultiRow(String name);

}
