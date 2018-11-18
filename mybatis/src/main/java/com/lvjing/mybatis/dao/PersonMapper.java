package com.lvjing.mybatis.dao;

import com.lvjing.mybatis.bean.Person;

import java.util.List;
import java.util.Map;

public interface PersonMapper {
    void delete(Integer id);

    void insert(Person person);

    Person selectOne(Map<String,Object> map);

    List<Person> selectSome(int[] group);

    List<Person> selectAll();
}
