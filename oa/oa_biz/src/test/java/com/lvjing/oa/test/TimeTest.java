package com.lvjing.oa.test;

import com.lvjing.oa.biz.EmployeeBiz;
import com.lvjing.oa.entity.Employee;
import com.lvjing.oa.global.RedisConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring-biz.xml"})
public class TimeTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private EmployeeBiz employeeBiz;

    @Test(timeout = 500)
    public void demo1() {
        HashOperations ops = redisTemplate.opsForHash();
        Object o = ops.get(RedisConstant.HASH_MAP, RedisConstant.All_EMPLOYEE);
        System.out.println(o);
    }

    @Test(timeout = 500)
    public void demo2() {
        List<Employee> o = employeeBiz.getAll();
        System.out.println(o);
    }

}
