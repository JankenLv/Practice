package com.lvjing.test;

import com.lvjing.cache.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class demo1 {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final Logger log = LoggerFactory.getLogger(demo1.class.getName());

    @Before
    public void init() {
//        org.apache.log4j.PropertyConfigurator.configure("log4j.properties");
    }

    @Test
    public void test1() {
        redisTemplate.opsForValue().set("loser","吕金盛");
        log.info("loser：{}",redisTemplate.opsForValue().get("loser"));
    }

    @Test
    public void test2() {
//        BoundValueOperations<String,String> ops = new StringRedisTemplate().boundValueOps("user_1");
//        ValueOperations ops = redisTemplate.opsForValue();
        HashOperations ops = redisTemplate.opsForHash();
        User user = new User();
        user.setName("郭美美");
        user.setAge("30");
        user.setSex("女");
        ops.put("hhh","user_1",user);
        log.info("user_1 ==> {}", ops.get("hhh","user_1"));
    }
}
