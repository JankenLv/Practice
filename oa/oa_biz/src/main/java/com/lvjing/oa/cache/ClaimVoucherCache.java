package com.lvjing.oa.cache;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


@Aspect
public class ClaimVoucherCache {

    @Autowired
    private RedisTemplate redisTemplate;

}
