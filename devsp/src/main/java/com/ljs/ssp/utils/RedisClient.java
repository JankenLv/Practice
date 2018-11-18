package com.ljs.ssp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 功能描述：Redis二次封装工具类
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/11 0:00 </p>
 */
@Component
public class RedisClient {

    @Autowired
    private StringRedisTemplate redisTep;

    /**
     * 功能描述：设置key-value到redis中
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value) {
        try {
            redisTep.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 功能描述：根据key从redis获取value
     * @param key
     * @return
     */
    public String get(String key) {
        return redisTep.opsForValue().get(key);
    }

}
