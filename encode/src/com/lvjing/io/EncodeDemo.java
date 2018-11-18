package com.lvjing.io;

public class EncodeDemo {

    public static void main(String[] args) throws Exception {
        String s = "吕金盛160";
        byte[] byte1 = s.getBytes(); // 使用项目的默认编码（UTF-8）获取字节码
        System.out.println("\n默认编码：");
        for (byte b : byte1) {
            // 把字节（转换成int）以16进制方式显示
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println("\nGBK：");

        byte[] byte2 = s.getBytes("GBK");
        for (byte b : byte2) {
            // GBK编码中文占用2个字节，英文占用1个字节
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println("\nUTF-8：");

        byte[] byte3 = s.getBytes("UTF-8");
        for (byte b : byte3) {
            // UTF-8编码中文占用3个字节，英文占用1个字节
            System.out.print(Integer.toHexString(b  & 0xff) + " ");
        }
        System.out.println("\nISO8859-1：");

        byte[] byte4 = s.getBytes("ISO8859-1");
        for (byte b : byte4) {
            // ISO8859-1编码中文占用1个字节，英文占用1个字节
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println("\nASCII：");

        byte[] byte5 = s.getBytes("ASCII");
        for (byte b : byte5) {
            // ASCII编码中文占用1个字节，英文占用1个字节
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println("\nUTF-16BE：");

        byte[] byte6 = s.getBytes("UTF-16BE");
        for (byte b : byte6) {
            // UTF-16BE编码中文占用1个字节，英文占用1个字节
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        /*
        当你的字节序列是某种编码时，这个时候想把字节序列变成字符串，
        也需要用这种编码方式，否则会出现乱码。

        文本文件，就是字节序列
        可以使任意编码的字节序列
        如果我们在中文机器上直接创建文本文件，那么该文件只认识ANSI编码
        联通、联是一种巧合，它们正好符合了UTF-8格式的编码
         */
    }
}
