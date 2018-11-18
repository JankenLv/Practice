package com.lvjing.code;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class encode {

    public static void main(String[] args) {
        try {
            String str = "中文";
            byte[] byte1 = str.getBytes("UTF-8");
            byte[] byte2 = str.getBytes("GB2312");
            byte[] byte3 = str.getBytes("ISO-8859-1");

            /*String s1 = new String(byte1, "UTF-8");
            String s2 = new String(byte2, "UTF-8");
            String s3 = new String(byte3, "UTF-8");
            String s4 = new String(byte1, "GB2312");
            String s5 = new String(byte2, "GB2312");
            String s6 = new String(byte3, "GB2312");
            String s7 = new String(byte1, "ISO-8859-1");
            String s8 = new String(byte2, "ISO-8859-1");
            String s9 = new String(byte3, "ISO-8859-1");

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            System.out.println(s4);
            System.out.println(s5);
            System.out.println(s6);
            System.out.println(s7);
            System.out.println(s8);
            System.out.println(s9);*/


            String encode1 = URLEncoder.encode(str, "UTF-8");
            String encode2 = URLEncoder.encode(str, "GB2312");
            String encode3 = URLEncoder.encode(str, "ISO-8859-1");

            String decode1 = URLDecoder.decode(encode1, "UTF-8");
            String decode2 = URLDecoder.decode(encode2, "GB2312");
            String decode3 = URLDecoder.decode(encode3, "ISO-8859-1");

            System.out.println(encode1);
            System.out.println(encode2);
            System.out.println(encode3);
           /* System.out.println(decode1);
            System.out.println(decode2);
            System.out.println(decode3);*/
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
