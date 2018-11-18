package com.ljs.export;

import org.junit.Test;

/**
 * 普通测试类
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/6 23:28 </p>
 */
public class SimpleTest {

    /**
     * 获取系统编码
     */
    @Test
    public void testSysEncoding() {
//        System.out.println(System.getProperty("sun.jnu.encoding"));
        System.out.println(System.getProperty("file.encoding"));
    }

}
