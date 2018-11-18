package net.xdclass.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 上下文监听器，当应用启动和销毁时，会触发该监听器
 * 使用场景：应用启动时加载资源
 * 常用于在应用启动时，启动子线程
 * 加载缓存（如redis）中的数据到本地
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/4 14:49 </p>
 */
@WebListener
public class ResourceLoadedListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("===>>> 资源加载监听器被触发 ===>>>");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("===>>> 资源加载监听器被销毁 ===>>>");
    }
}
