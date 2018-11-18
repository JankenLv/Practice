package net.xdclass.demo.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 请求监听器，当应用接受一个http请求的时候，会触发该监听器
 * 使用场景：统计网站访问量
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/4 14:54 </p>
 */
@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("===>>> 请求监听器被销毁 ===>>>");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("===>>> 请求监听器被触发 ===>>>");
    }
}
