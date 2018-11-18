package com.ljs.ssp.controller;

import com.ljs.ssp.domain.JsonData;
import com.ljs.ssp.domain.User;
import com.ljs.ssp.utils.JsonUtils;
import com.ljs.ssp.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 功能描述：SpringBoot整合Redis实战
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/10 21:23 </p>
 */
@RestController
@RequestMapping("/api/v1/redis")
public class RedisTestController {

    private static final String key = "base:user:11";

    private static final String key2 = "base::user::11";

    @Autowired
    private StringRedisTemplate redisTep;

    @Autowired
    private RedisClient redisClient;

    @GetMapping("/add")
    public Object add(@RequestParam String value) {
        redisTep.opsForValue().set("name", value);
        return JsonData.buildSuccess("ok");
    }

    @GetMapping("/get")
    public Object get(@RequestParam String key) {
        Object value = redisTep.opsForValue().get(key);
        return JsonData.buildSuccess(value);
    }

    @GetMapping("/save_user")
    public Object saveUser() {
        User user = new User(22,"ljs_111","12344678",new Date());
        String userStr = JsonUtils.obj2String(user);
//        boolean flag = redisClient.set(key, userStr);
        boolean flag = redisClient.set(key2, userStr);
        return JsonData.buildSuccess(flag);
    }

    @GetMapping("/get_user")
    public Object getUser() {
        String userStr = redisClient.get(key);
        User user  = JsonUtils.string2Obj(userStr, User.class);
        return JsonData.buildSuccess(user);
    }

}
