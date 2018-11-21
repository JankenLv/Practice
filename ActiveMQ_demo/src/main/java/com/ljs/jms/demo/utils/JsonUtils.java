package com.ljs.jms.demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

/**
 * 功能描述：JSON/对象转换工具类
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/10 23:47 </p>
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 功能描述：对象转字符串
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String obj2String(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述：字符串转对象
     *
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T string2Obj(String str, Class<T> clazz) {
        if (StringUtils.isEmpty(str) || clazz == null) {
            return null;
        }
        try {
            return clazz.equals(String.class) ? (T) str : objectMapper.readValue(str, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
