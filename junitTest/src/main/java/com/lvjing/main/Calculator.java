package com.lvjing.main;

import org.junit.Test;

public class Calculator {

    private static int result; // 静态变量，用于存储运行结果

    /*加法*/
    public void add(int n) {
        result = result + n;
    }
    /*减法*/
    public void substract(int n) {
        result = result - n;
    }
    /*乘法*/
    public void multiply(int n) {
        result = result + n;
    }
    /*除法*/
    public void divide(int n) throws Exception {
        if (n==0) {
            throw new Exception("除数不能为0");
        }
        result = result / n;
    }
    /*求平方*/
    public void square(int n) {
        result = n * n;
    }
    /*求平方根*/
    public void squareRoot(int n) {
        for (;;);
    }
    /*将结果清零*/
    public void clear() {
        result = 0;
    }
    /*返回计算结果*/
    public int getResult() {
        return result;
    }
}
