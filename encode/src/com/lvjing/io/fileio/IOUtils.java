package com.lvjing.io.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * I/O工具类
 */
public class IOUtils {

    /**
     * 获取输入流文件，打印输出其字节数组
     * 每打印输出10个字节换一行
     * @param path 文件路径
     */
    public static void printHex(String path){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            int b;
            int i = 1;
            while ((b = fis.read()) != -1) {
                //带位数前面补0
                if (b <= 0xf) {
                    System.out.print("0");
                }

                //把字节转换为16进制字符串
                System.out.print(Integer.toHexString(b) + " ");

                //每打印输出10个字节换一行
                if (i++ % 10 == 0) {
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取输入流文件，打印输出其字节数组
     * 每打印输出10个字节换一行
     * @param fileName 文件路径
     */
    public static void printHexByByteArrays(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)){
            //用一个byte数组存储文件输入流的字节
            byte[] buf = new byte[8 * 1024];

            /*
            从int中批量读取字节，放入到buf这个字节数组中，
            从第0个位置开始放，最多当buf.length个
            返回的是读取到的字节的个数
             */
            /*int bytes = fis.read(buf,0,buf.length); //一次性读完，说明字节数组足够大

            int j = 1;
            for (byte aBuf : buf) {
                //若字节只有一位，前面补0
                if (aBuf <= 0xf) {
                    System.out.print("0");
                }

                //把字节转换为16进制字符串打印输出
                System.out.print(Integer.toHexString(aBuf & 0xff) + " ");

                //每打印输出10个字节，换一行
                if (j++ % 10 == 0) {
                    System.out.println();
                }
            }*/

            int b = 0;
            int j = 1;
            while ((b = fis.read(buf,0,buf.length)) != -1) {
                //b的长度，是有效的字节数据
                for (int i = 0;i < b; i++) {
                    //如果字节只有一位，前面补0
                    if (buf[i] <= 0xf) {
                        System.out.print("0");
                    }

                    //把字节转换为16进制字符串打印输出
                    //byte类型8位，int类型32位，为了避免数据转换错误，通过0xff将高24位清零
                    System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");

                    //每打印输出10个字节，换一行
                    if (j++ %10 ==0) {
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 复制文件
     * @param file 要复制的文件
     * @param newFile 新文件
     */
    public static void copyFile(String file, String newFile) {
        File f = new File(file);
        if (!f.exists()) {
            throw new IllegalArgumentException("文件 " + f + " 不存在！");
        }
        if (!f.isFile()) {
            throw new IllegalArgumentException(f + " 不是文件！");
        }

        try (
            FileInputStream is = new FileInputStream(f);
            FileOutputStream os = new FileOutputStream(newFile);
        ) {
            byte[] buf = new byte[1024];
            int b;
            while ((b = is.read(buf,0,buf.length)) != -1) {
                os.write(buf,0,b);
                os.flush();  //最好加上
            }
            //打印输出操作结果
            System.out.println("文件：" + file + (new File(newFile).exists() ? " 复制成功！" : " 复制失败！"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
