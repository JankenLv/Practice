package com.lvjing.oa.cache;

import com.lvjing.oa.biz.EmployeeBiz;
import com.lvjing.oa.entity.Employee;
import com.lvjing.oa.global.RedisConstant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 员工数据缓存类
 */
@Component
@Aspect
public class EmployeeCache {

    private static final Logger log = LoggerFactory.getLogger(EmployeeCache.class.getName());

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private EmployeeBiz employeeBiz;

    @Pointcut(value = "execution(* com.lvjing.oa.biz.impl.EmployeeBizImpl.getAll(..))")
    public void pointcutForGetAll() {}

    @Pointcut(value = "execution(* com.lvjing.oa.biz.impl.EmployeeBizImpl.get(..))")
    public void pointcutForGet() {}

    @Pointcut(value = "execution(* com.lvjing.oa.biz.impl.EmployeeBizImpl.remove(..))")
    public void pointcutForRemove() {}

    @Pointcut(value = "execution(* com.lvjing.oa.biz.impl.EmployeeBizImpl.edit(..))")
    public void pointcutForEdit() {}

    @Pointcut(value = "execution(* com.lvjing.oa.biz.impl.EmployeeBizImpl.add(..))")
    public void pointcutForAdd() {}



    /**
     * 获取sn获取缓存的员工数据，若不存在，则缓存数据
     */
    @Around(value = "pointcutForGet()")
    public Object cacheForGet(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        return cacheInHash(getEmployeeKey(args[0]),joinPoint);
    }

    /**
     * 获取所有缓存的员工数据，若不存在，则缓存数据
     */
    @Around(value = "pointcutForGetAll()")
    public Object cacheForGetAll(ProceedingJoinPoint joinPoint) {
        return cacheInHash(RedisConstant.All_EMPLOYEE,joinPoint);
    }

    /**
     * 根据sn删除缓存的员工数据
     */
    @Before(value = "pointcutForRemove()")
    public void cacheForRemove(JoinPoint joinPoint) {
        try {
            Object[] args = joinPoint.getArgs();
            String key = getEmployeeKey(args[0]);
            delHashCache(key);
            asyncUpdateCache();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * 更新员工信息后，更新缓存的员工数据
     */
    @AfterReturning(value = "pointcutForEdit()", returning = "result")
    public void cacheForEdit(Object result) {
        Employee emp = (Employee) result;
        doHashCache(getEmployeeKey(emp.getSn()),emp);
        asyncUpdateCache();
    }

    /**
     * 添加新员工后，缓存员工数据
     */
    @AfterReturning(value = "pointcutForAdd()", returning = "result")
    public void cacheForAdd(Object result) {
        Employee emp = (Employee) result;
        doHashCache(getEmployeeKey(emp.getSn()),emp);
        asyncUpdateCache();
    }

    /**
     * 当数据库的数据更新后，异步更新redis中的数据
     */
    private void asyncUpdateCache() {
        Thread t = new Thread(this::updateCache);
        t.start();
    }

    /**
     * 更新缓存的所有员工数据
     */
    private void updateCache() {
        List<Employee> employees = employeeBiz.updateAll();
        doHashCache(RedisConstant.All_EMPLOYEE,employees);
    }


    /**
     * 存取redis中hash的数据
     * @param key 获取的key
     * @param joinPoint 切点方法
     * @return Object
     */
    private Object cacheInHash(String key, ProceedingJoinPoint joinPoint) {
        String hash = RedisConstant.HASH_MAP;
        HashOperations ops = redisTemplate.opsForHash();
        Object o = null;
        try {
            o = ops.get(hash, key);
            if (o == null) {
                try {
                    o = joinPoint.proceed();
                    if (o != null) {
                        doHashCache(key,o);
                    }
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        } catch (RedisConnectionFailureException e) {
            e.printStackTrace();
            log.info("#================= redis数据库连接失败 ==================>");
            try {
                o = joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        return o;
    }

    /**
     * 返回统一命名的key
     * @param id employee的id
     * @return string
     */
    private String getEmployeeKey(Object id) {
        return RedisConstant.EMPLOYEE + "_" + id;
    }

    /**
     * 存储hash数据类型到redis
     * @param key key
     * @param val value
     */
    private void doHashCache(String key, Object val) {
        try {
            String hashMap = RedisConstant.HASH_MAP;
            HashOperations ops = redisTemplate.opsForHash();
            ops.put(hashMap, key, val);
            log.info("#================== 缓存数据 ===============> hashMap: {}  ##  key: {}", hashMap, key);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("#================= redis数据库连接失败 ==================>");
        }
    }

    /**
     * 删除hash表中的key
     * @param key key
     */
    private void delHashCache(String key) {
        try {
            String hashMap = RedisConstant.HASH_MAP;
            HashOperations ops = redisTemplate.opsForHash();
            ops.delete(hashMap,key);
            log.info("#================== 删除缓存数据 ===============> hashMap: {}  ##  key: {}", hashMap, key);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("#================= redis数据库连接失败 ==================>");
        }
    }
}
