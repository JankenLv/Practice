package com.lvjing.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lvjing.mybatis.bean.Person;
import com.lvjing.mybatis.dao.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterTest {

    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    private SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            try {
                InputStream is = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }

    private void close() {
        if (sqlSession != null) {
            sqlSession.close();
        }
        sqlSession = null;
    }

    private Person buildPerson(String name, String gender, Integer deptId) {
        Person person = new Person();
        person.setUsername(name);
        person.setGender(gender);
        person.setDeptId(deptId);
        return person;
    }

    private Map<String, Object> buildMap(String name, Integer deptId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("deptId", deptId);
        return map;
    }


    public void addPerson() {
        try {
            sqlSession = getSqlSessionFactory().openSession();
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            mapper.insert(buildPerson("小李", "男", 2));
            sqlSession.commit();
        } finally {
            close();
        }
    }


    public void findPerson() {
        try {
            sqlSession = getSqlSessionFactory().openSession();
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            Person person = mapper.selectOne(buildMap("小红", 1));
            System.out.println(person);
        } finally {
            close();
        }
    }


    public void findSomePerson() {
        try {
            sqlSession = getSqlSessionFactory().openSession();
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            List list = mapper.selectSome(new int[]{1, 2, 3, 5});
            System.out.println(list);
        } finally {
            close();
        }
    }


    public void addMorePerson() {
        try {
            sqlSession = getSqlSessionFactory().openSession(ExecutorType.BATCH);
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

            for (int i = 0; i < 1000; i++) {
                mapper.insert(buildPerson("robot" + i, "f", i));
            }
            sqlSession.commit();
        } finally {
            close();
        }
    }

    @Test
    public void findAllPersons() {
        try {
            sqlSession = getSqlSessionFactory().openSession();
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            Page<Object> page = PageHelper.startPage(1, 20);
            List<Person> list = mapper.selectAll();
            System.out.println("\n分页后的数量："+list.size());
        } finally {
            close();
        }
    }
}
