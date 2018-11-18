package com.lvjing.rd;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestRedis {

    /**
     * 直接jedis连接redis
     */
    @Test
    public void demo1() {
        Jedis jedis = new Jedis("192.168.48.130",6379);
        jedis.set("name","小明");
        jedis.set("sex","男");
        System.out.println("姓名："  + jedis.get("name") + "\n性别：" + jedis.get("sex"));
        jedis.close();
    }

    /**
     * 使用连接池连接redis
     */
    @Test
    public void demo2() {
        // 设置连接池参数
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMinIdle(15);

        // 初始化jedis连接池
        JedisPool jedisPool = new JedisPool(config,"192.168.48.130",6379);
        Jedis jedis = null;

        try {
            // 连接redis
            jedis = jedisPool.getResource();
            jedis.set("name","小红");
            jedis.set("nickName","红红");
            System.out.println("姓名：" + jedis.get("name") + "\n昵称：" + jedis.get("nickName"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭jedis和连接池
            if (jedis != null) {
                jedis.close();
                jedis = null;
            }
            jedisPool.close();
        }
    }
}
