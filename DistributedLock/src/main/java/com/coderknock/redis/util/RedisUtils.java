package com.coderknock.redis.util;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis工具类
 */
public class RedisUtils {

    public static JedisPool pool;

    private final static String host = "192.168.48.130";
    private final static int port = 6379;

    static{
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinIdle(10);
        config.setMaxIdle(30);
        pool = new JedisPool(config,host,port);
    }
}
