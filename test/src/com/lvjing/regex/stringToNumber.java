package com.lvjing.regex;

public class stringToNumber {
    public static void main(String[] args) {
        /*String s = "1";
        System.out.println(s.matches("\\d"));
        String s1 = String.valueOf(Float.valueOf(s));
        System.out.println(s1);*/

        /*String s = "11.0";
        if (s.matches("\\w+")) {
            s = String.valueOf(Float.valueOf(s));
        }
        System.out.println(s);*/

        String s = "11.5";
        System.out.println(Float.valueOf(s));

    }
}
