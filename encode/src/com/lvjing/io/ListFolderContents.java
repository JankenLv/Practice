package com.lvjing.io;

import java.io.File;

public class ListFolderContents {

    public static void main(String[] args) {
        getFolderContents("D:\\BaiduNetdiskDownload");
    }

    /**
     * 遍历磁盘路径下的目录
     * @param path 磁盘路径
     */
    private static void getFolderContents(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File f : files) {
                    if (f.isFile()) {
                        System.out.println(f);
                    }
                    if (f.isDirectory()) {
                        getFolderContents(f.getPath());
                    }
                }
            }

        }
    }
}
