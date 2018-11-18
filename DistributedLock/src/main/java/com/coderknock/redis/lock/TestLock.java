package com.coderknock.redis.lock;

import com.coderknock.redis.util.RedisUtils;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class TestLock {
    private final static String SANCHAN_MONEY = "SANCHAN_MONEY";
    private final static String SANCHAN_MONEY_LOCK = "SANCHAN_MONEY_LOCK";

    /**
     * 没有锁的时候的情况
     * @throws InterruptedException
     */
    public static Runnable notLock() throws InterruptedException{
        return () ->{
            try (Jedis jedis = RedisUtils.pool.getResource()) {
                calImpl(jedis);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    /**
     * 有锁的时候的情况
     * @throws InterruptedException
     */
    private static Runnable lock() throws InterruptedException{
        return () ->{
            LockInitial lockInitial = new LockInitial();
            try (Jedis jedis = RedisUtils.pool.getResource()) {
                cal(lockInitial,jedis);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    private static void cal(LockInitial lockInitial, Jedis jedis) {
        if (lockInitial.tryLock(jedis, SANCHAN_MONEY_LOCK, "100", 1000L)) {
            calImpl(jedis);
            lockInitial.releaseLock(jedis, SANCHAN_MONEY_LOCK, "100");
        } else {
            cal(lockInitial,jedis);
        }
    }

    /**
     * 计算
     * @param jedis
     */
    private static void calImpl(Jedis jedis) {
        int money = Integer.parseInt(jedis.get(SANCHAN_MONEY));
        jedis.set(SANCHAN_MONEY,String.valueOf(money - 100));
        System.out.println("计算" + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        try (Jedis jedis = RedisUtils.pool.getResource()) {
            jedis.set(SANCHAN_MONEY, "1000");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Runnable runnable = notLock();
        Runnable runnable = lock();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable,String.valueOf(i));
            thread.start();
        }

        TimeUnit.SECONDS.sleep(5);

        try (Jedis jedis = RedisUtils.pool.getResource()) {
            int money = Integer.parseInt(jedis.get(SANCHAN_MONEY));
            System.out.println(money);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
