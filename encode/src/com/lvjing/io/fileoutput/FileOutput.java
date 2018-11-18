package com.lvjing.io.fileoutput;

import com.lvjing.io.fileio.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {

    public static void main(String[] args) {
        FileOutputStream os = null;
        try {
            /*
            如果该文件不存在，则直接创建，如果存在，删除后创建。
            如果不希望删除已存在的文件，可以使用另一个构造方法，把最后一个参数append设置为true，
            表示向文件追加内容，不会去删除已存在的文件。
            */
            os = new FileOutputStream("demo\\out.dat");
            os.write('A');  //写出了'A'的低八位
            os.write('b');  //写出了'b'的低八位
            int a = 10;  //write只能写八位，那么写一个int(32位)需要写4次，每次写8位
            os.write(a >>> 24);
            os.write(a >>> 16);
            os.write(a >>> 8);
            os.write(a);

            //也可以直接写一个字节数组
            byte[] b = "中国".getBytes();
            os.write(b);

            IOUtils.printHex("demo\\out.dat");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
