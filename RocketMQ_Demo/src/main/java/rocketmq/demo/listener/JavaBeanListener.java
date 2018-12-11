package rocketmq.demo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import rocketmq.demo.jms.MsgProducer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 功能描述：初始化和销毁Java Bean的监听器
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/12/8 23:05 </p>
 */
@WebListener
public class JavaBeanListener implements ServletContextListener {

    @Autowired
    private MsgProducer msgProducer;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("============= 系统启动中 =============");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        msgProducer.shutDownMQProducer();
        System.out.println("============= 释放系统资源完毕 =============");
    }

}
