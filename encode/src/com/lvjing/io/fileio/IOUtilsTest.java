package com.lvjing.io.fileio;

public class IOUtilsTest {

    public static void main(String[] args) {
//        IOUtils.printHex("D:\\IOUtils.java");
//        IOUtils.printHexByByteArrays("D:\\IOUtils.java");
        IOUtils.copyFile("demo/1.txt","demo/2.txt");
    }
}
