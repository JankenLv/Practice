package com.verificationcode.Utils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

/**
 * 验证码工具类
 */
public class CaptchaCode {

    // 测试
    public static void main(String[] args) {
        System.out.println(drawImage(null));
    }

    // 获取一个日志对象进行调试
    private static Logger logger = Logger.getGlobal();

    /**
     * 生成随机数字、字母的方法
     */
    public static String drawImage(HttpServletResponse response) {
        logger.info("drawImage方法被调用了");

        // 1.定义一个字符串的拼接的StringBuilder：
        StringBuilder builder = new StringBuilder();

        // 2.准备产生4个字符串的随机数：
        for (int i = 0; i < 4; i++) {
            builder.append(getRandomChar());
        }
        String num = builder.toString();

        // 3.建立 bufferedImage 对象，指定图像的长度和宽度以及色彩：
        int width = 120;
        int height = 25;
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);

        // 4.获取 Graphtics2D 绘制对象，开始绘制验证码：
        Graphics2D g = bi.createGraphics();

        // 5.设置文字的字体和大小：
        Font font = new Font("微软雅黑",Font.PLAIN,20);
        // 6.设置字体颜色：
        Color color = new Color(0,0,0);
        // 7.设置背景：
        Color backgroundColor = new Color(226,226,240);

        g.setFont(font);
        g.setColor(color);
        g.setBackground(backgroundColor);

        // 开始绘制对象
        g.clearRect(0,0,width,height);

        // 8.绘制形状（一般为矩形）：
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(num,context);

        // 9.计算文件的坐标和间距：
            // 测试坐标系与图形的关系：
           /* double bwidth = bounds.getWidth();
            double bheight = bounds.getHeight();
            double bx = bounds.getX();
            double by = bounds.getY();
            System.out.println("bwidth: " + bwidth + " bheight: " + bheight);
            System.out.println("bx: " + bx + " by: " + by);*/

        double x = (width - bounds.getWidth())/2;
        double y = (height - bounds.getHeight())/2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
//        System.out.println("x: " + x + " y: " + y + " getY: " + ascent + " baseY: " + baseY);
        g.drawString(num,(int)x,(int)baseY);

        // 10.结束绘制：
        g.dispose();

        // 11.输出验证码：
        try {
            ImageIO.write(bi,"jpg",response.getOutputStream());
            // 刷新响应流
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("num: " + num);
        return num;
    }

    /**
     * 产生算术验证码的方法
     */
    public static int drawArithmeticImage(HttpServletResponse response) {
        // 获取一个random对象：
        Random random = new Random();

        // 1.设定宽和高：
        int width = 100,height = 25;

        // 2.获取内存缓存对象：
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);

        // 3.获取绘制对象：
        Graphics2D g = image.createGraphics();

        // 4.设定字体、颜色等：
        Font font = new Font("微软雅黑",Font.PLAIN,20);
        g.setFont(font);
        g.setColor(getRandomColor(200,250));
        g.setBackground(getRandomColor(100,150));
        // 清除默认背景颜色：
        g.clearRect(0,0,width,height);

        // 5.获取算术表达式：
        // 5.1 获取随机数字(10以内)：
        int num1 = (int)(Math.random()*10 + 1);
        int num2 = (int)(Math.random()*10 + 1);
        // 5.2 获取算术符号，计算算术表达式结果：
        String symbol = "";
        int result = 0;
        int flag = random.nextInt(3);
        switch (flag) {
            case 0: symbol = "+";result = num1 + num2;break;
            case 1: symbol = "-";result = num1 - num2;break;
            case 2: symbol = "X";result = num1 * num2;break;
        }
        // 5.3 保存算术表达式：
        String code = num1 + " " + symbol + " " + num2;

        // 6.把算术表达式绘制到矩形图形中：
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code,context);

        // 7.绘制算术表达式：
        double x = (width - bounds.getWidth())/2;
        double y = (height - bounds.getHeight())/2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
//        System.out.println("x: " + x + " y: " + y + " getY: " + ascent);
        g.drawString(code, (int)x, (int)baseY);


        // 8.绘制干扰线条：
        g.setColor(getRandomColor(180,200));
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt((width/2));
            int y1 = random.nextInt(height);
            int x2 = x1 + 60;
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        // 8.关闭 Graphics2D 对象，结束绘制：
        g.dispose();

        // 9.输出验证码：
        try {
            ImageIO.write(image,"jpg",response.getOutputStream());
            response.flushBuffer();
            // 10.返回算术表达式结果：
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return 999;
        }

    }


    /**
     * 产生随机数字和字母
     */
    private static char getRandomChar() {
        // 1.定义需要验证的字母和数字
        String str = "QWERTYUIOPASDFGHJKLZXCVBNM123456789";
        // 2.定义随机对象：
        Random random = new Random();

        return str.charAt(random.nextInt(str.length()));
    }

    /**
     * 产生随机颜色
     */
    public static Color getRandomColor(int fc, int bc) {
        // 获取 random 对象：
        Random random = new Random();
        // 获取随机R、G、B：
        if(fc>255)fc=255;
        if(bc>255)bc=255;
        int r = fc + random.nextInt(bc-fc);
        int g = fc + random.nextInt(bc-fc);
        int b = fc + random.nextInt(bc-fc);

        return new Color(r,g,b);

    }
}
