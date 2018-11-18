package net.xdclass.demo.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Http会话监听器，浏览器发起和销毁一个会话的时候会触发该监听器
 * 使用场景：统计网站当前在线人数
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/4 15:24 </p>
 */
@WebListener
public class SessionCounter implements HttpSessionListener {

    /* 在线人数统计 */
    private static int activeSessions =0;

    /* Session创建事件 */
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = se.getSession( ).getServletContext( );
        Integer numSessions = (Integer) ctx.getAttribute("numSessions");
        if (numSessions == null) {
            numSessions = 1;
        }
        else {
            int count = numSessions;
            numSessions = count + 1;
        }

        System.out.println("当前在线用户：" + activeSessions);
        ctx.setAttribute("numSessions", numSessions);
    }

    /* Session失效事件 */
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx=se.getSession().getServletContext();
        Integer numSessions = (Integer)ctx.getAttribute("numSessions");
        if(numSessions == null){
                numSessions = 0;
        }else {
            int count = numSessions;
            numSessions = count - 1;
        }

        System.out.println("当前在线用户：" + activeSessions);
        ctx.setAttribute("numSessions", numSessions);
    }
}
