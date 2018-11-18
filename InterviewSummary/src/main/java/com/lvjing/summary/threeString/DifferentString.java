package com.lvjing.summary.threeString;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * String、StringBuilder、StringBuffer的区别
 * String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，
 * 即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的。
 *
 * 如果要进行的操作是多线程的，那么就要使用StringBuffer，
 * 但是在单线程的情况下，还是建议使用速度比较快的StringBuilder。
 */
public class DifferentString {

    private StringBuilder stringBuilder = new StringBuilder();

    private StringBuffer stringBuffer = new StringBuffer();

    private static final String builder = "builder";

    private static final String buffer = "buffer";

    @Test(timeout = 200)
    public void testString() {
        /*1、String是字符串常量，一旦创建之后该对象是不可更改的
        * 例如像下面的赋值操作：
        * aa这一个字符串并没有被改变
        * 而是新建了一个字符串bb并赋值给str
        */
        String str = "aa";
        String str1 = "bb";
        String str2 = str + str1;
        System.out.println(str2);
    }

    @Test(timeout = 200)
    public void testStringBuilder() throws InterruptedException {
        /*2、StringBuilder创建的字符串变量,长度是可以改变的
        *StringBuilder不是线程安全的
        * 当有多个线程同时操作StringBuilder创建的字符串，
        * 可能会出现错误的操作
        *
        * 多线程操作StringBuilder,生成的字符串的先后顺序是不可预测的
        */
        createThread(10,builder);
        TimeUnit.MILLISECONDS.sleep(5);
        System.out.println(stringBuilder.toString());

    }

    @Test(timeout = 200)
    public void testStringBuffer() throws InterruptedException {
        /*3、StringBuffer创建的字符串变量,长度是可以改变的
        *StringBuffer是线程安全的，因为其内部许多方法使用了synchronized关键字
        * 所以可以保证线程是安全的
        *
        * 多线程访问StringBuffer,生成的字符串是按先后顺序组合的
        */
        createThread(10,buffer);
        TimeUnit.MILLISECONDS.sleep(5);
        System.out.println(stringBuffer.toString());
    }

    /**
     * 创建指定数量的线程，执行构造字符串的方法
     * @param threadNum  线程数量
     */
    private void createThread(Integer threadNum, final String assign) {
        for (int i = 0; i < threadNum; i++) {
            if (i % 2 == 0) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        buildStr("aa",assign);
                    }
                }).start();
            } else {
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        buildStr("bb",assign);
                    }
                }).start();
            }
        }
    }

    /**
     * 使用StringBuilder构造字符串
     * @param appendStr 追加字符串
     */
    private void buildStr(String appendStr,String assign) {
        if (assign.equals(builder))
            stringBuilder.append(appendStr);

        if (assign.equals(buffer))
            stringBuffer.append(appendStr);
    }

}
