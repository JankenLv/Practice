package com.lvjing.summary.getValues;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 获取map中所有的value
 */
public class GetMapValues {

    @Test(timeout = 500)
    public void test() {
        method1(getMap());
//        method2(getMap());
//        method3(getMap());
//        method4(getMap());
    }

    /**
     * 方法1：通过entrySet()方法获取此映射中包含的映射关系的Set视图
     * 遍历Set视图，获取key和value
     * @param map map
     */
    private void method1(Map<Integer,Object> map) {
        Set<Map.Entry<Integer, Object>> entries = map.entrySet();
        for (Map.Entry<Integer, Object> entry : entries) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
    }

    /**
     * 方法2：通过values()获取此映射中包含的值的Collection视图
     * @param map map
     */
    private void method2(Map<Integer,Object> map) {
        for (Object o : map.values()) {
            System.out.println("value: " + o);
        }
    }

    /**
     * 方法3：通过keySet()获取此映射中包含的键的Set视图
     * 遍历键的Set视图，使用get(Object key)方法获取value
     * @param map map
     */
    private void method3(Map<Integer,Object> map) {
        for (Integer key: map.keySet()) {
            System.out.println("key: " + key + " value: " + map.get(key));
        }
    }


    /**
     * 方法4：通过entrySet()方法获取此映射中包含的映射关系的Set视图
     * 获取Set视图的Iterator，通过Iterator获取key和value
     * @param map map
     */
    private void method4(Map<Integer,Object> map) {
        Set<Map.Entry<Integer, Object>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Object> entry = iterator.next();
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

    }

    private Map<Integer, Object> getMap() {
        Map<Integer,Object> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put(i,"aa_" + i);
        }

        return map;
    }

}
