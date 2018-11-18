package com.lvjing.domain;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class demo {

    private JdbcTemplate template;

    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        template = (JdbcTemplate) context.getBean("jdbcTemplate");
    }


    public void test1() {
        String sql = "select COUNT(*) from mytest.user";
        int count = template.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

//    @Test
    public void test2() {
        String sql = "select * from mytest.user";
        List<Map<String,Object>> list = template.queryForList(sql);
        System.out.println(list);
    }

    @Test
    public void test3() {
        String sql = "select * from mytest.user where id = ?";
        Map<String,Object> list = template.queryForMap(sql,1);
        System.out.println(list);
    }



}
