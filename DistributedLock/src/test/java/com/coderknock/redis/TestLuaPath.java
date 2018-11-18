package com.coderknock.redis;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestLuaPath {

    @Test
    public void testLuaPath() {
        String url = ClassLoader.getSystemResource("").getPath();
        String contextPath = url.substring(1, url.indexOf("/target"));
        String path = url.substring(1, url.indexOf("/target")) + "/src/main/resources/file/hello.txt";
        try (InputStream is = new FileInputStream(path)){
            byte[] b = new byte[is.available()];
            is.read(b);
            String ss = new String(b);
            System.out.println(path);
            System.out.println(ss);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
