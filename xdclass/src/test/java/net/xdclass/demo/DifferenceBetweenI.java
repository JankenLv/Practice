package net.xdclass.demo;

import org.junit.Test;

/**
 * 测试 i++ 和 ++i 有什么不同
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/3 23:19 </p>
 */
public class DifferenceBetweenI {

    @Test
    public void testI() {
        // i++ 先赋值，再自增
        int a = 1;
        int b =  a++;
        System.out.println("a is: " + a + " and b is: " + b + "\n");

        // ++i 先自增，再赋值
        int c = 1;
        int d = ++c;
        System.out.println("c is: " + c + " and d is: " + d + "\n");
    }
}
