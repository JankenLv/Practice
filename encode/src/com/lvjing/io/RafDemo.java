package com.lvjing.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RafDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("demo");
        if (!file.exists()) {
            file.mkdirs();
        }

        File demo = new File("demo", "raf.dat");
        if (!demo.exists()) {
            demo.createNewFile();
            System.out.println(demo.getAbsolutePath());
        }

        RandomAccessFile raf = new RandomAccessFile(demo,"rw");
        // 指针的位置（把大文件分割为小部件下载；下载完成，通过指针的位置组合文件。--迅雷的实现方式）
        System.out.println(raf.getFilePointer());

        raf.write('A');// 只写了一个字节
        System.out.println(raf.getFilePointer());

        raf.write('B');

        int i = 0x7fffffff;
        //用write方法，每次只能写一个字节，如果要把i写入，就要写四次
        raf.write(i >>> 24);//高8位
        raf.write(i >>> 16);
        raf.write(i >>> 8);
        raf.write(i);
        System.out.println(raf.getFilePointer());

        // 可以直接写一个int
        raf.writeInt(i);

        String s = "中";
        byte[] bytes = s.getBytes();
        raf.write(bytes);
        System.out.println(raf.length());

        //读文件，必须把指针移到头部
        raf.seek(0);
        //一次性读取，把文件中的内容都读到字节数组中
        byte[] b = new byte[(int) raf.length()];
        raf.read(b);
        System.out.println(Arrays.toString(b));

        //把字节数组转换为字符串输出
        String str = new String(b);
        System.out.println(str);

        //打印输出字节数组的每个字节
        for (byte b1 : b) {
            System.out.println(Integer.toHexString(b1 & 0xff));
        }

        //最后记得关闭
        raf.close();

    }
}
