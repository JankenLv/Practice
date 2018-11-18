package com.lvjing.code;

public class lengthOfString {
    public static void main(String[] args) {
        String str1 = "JAVA";
        String str2 = "变成小狗";
        String str3 = "CSS入门";
        String str4 = "Linux";

        int length1 = str1.getBytes().length;
        int length2 = str2.getBytes().length;
        int length3 = str3.getBytes().length;
        int length4 = str4.getBytes().length;

        System.out.println(length1);
        System.out.println("\n" + length2);
        System.out.println("\n" + length3);
        System.out.println("\n" + length4);
    }
}
