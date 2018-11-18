package com.lvjing.code;

import com.lvjing.entity.Books;

import java.lang.reflect.Field;

public class getField {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.lvjing.entity.Books");
        Books book = (Books) aClass.newInstance();

        // 修改一个public变量
        Field price = aClass.getField("price");
        price.set(book,"1500");
        System.out.println(price.get(book));


        // 修改一个private变量
        Field bookName = aClass.getDeclaredField("bookName");
        bookName.setAccessible(true);
        bookName.set(book,"水浒传");
        System.out.println(book);
    }
}
