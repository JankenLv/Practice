package com.coderknock.redis.lock;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.*;

public class LockInitial implements Lock{

    /**
     * 加锁
     * @param key 代表锁的key
     * @param val 锁的value
     * @param ttl 过期时间
     * @return 锁创建成功返回true；否则返回false
     */
    @Override
    public boolean tryLock(Jedis jedis, String key, String val, long ttl) {
        /*
        jedis的set重载方法参数详解
        key：要添加的key
        val：key的值
        nxxx：判断key是否已存在，NX|XX -> NX:key不存在才设置；XX:key存在才设置（防止重复建锁）
        expx：到期时间单位，EX|PX ->EX:秒；PX:毫秒（清除如用户宕机等长时间无响应的连接）
        ttl：到期时间
         */
        String result = jedis.set(key,val,"NX","EX",ttl);
        return "OK".equals(result);
    }

    /**
     * 释放锁(自己加的锁自己去释放 )
     * @param key 代表锁的key
     * @param val 锁的value
     * @return 锁存在并且删除成功后返回true；否则返回false
     */
    @Override
    public boolean releaseLock(Jedis jedis, String key, String val) {
        // 1、使用java代码释放锁
        /*if (val.equals(jedis.get(key))) {
            return jedis.del(key) > 0;
        }
        return false;*/


        // 2、使用lua脚本的方式释放锁
        String url = ClassLoader.getSystemResource("").getPath();
        String scriptPath = url.substring(1, url.indexOf("/target")) + "/target/classes/lua/releaseLock.lua";
        String script = null;
        try (InputStream is = new FileInputStream(scriptPath)){
            byte[] b = new byte[is.available()];
            is.read(b);
            script = new String(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jedis.eval(script,1,key,val).equals("1");
    }

    @Test
    /**
     * 测试方法
     * 读取lua脚本文件，转换为String
     */
    public void testPath() {
        String url = ClassLoader.getSystemResource("").getPath();
        String scriptPath = url.substring(1, url.indexOf("/target")) + "/target/classes/lua/releaseLock.lua";
        try (FileInputStream is = new FileInputStream(scriptPath)){
            byte[] b = new byte[is.available()];
            is.read(b);
            String script = new String(b);
            System.out.println(script);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
