package com.coderknock.redis.lock;

import redis.clients.jedis.Jedis;

/**
 * lock接口
 */
public interface Lock {

    /**
     * 测试枷锁
     * @return
     */
    boolean tryLock(Jedis jedis, String lock, String val, long ttl);

    /**
     * 释放锁
     * @return
     */
    boolean releaseLock(Jedis jedis, String key, String val);
}
