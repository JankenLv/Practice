package com.ljs.jms.demo.service;

import javax.jms.Destination;

/**
 * 功能描述：消息生产
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/21 22:59 </p>
 */
public interface ProducerService {

    /**
     * 功能描述：指定消息队列，还有消息
     * @param destination
     * @param message
     */
    void sendMessage(Destination destination, final String message);

   /**
    * 功能描述：使用默认消息队列，发送消息
    * @param message
    * @return void
    */
    void sendMessage(final String message);

}
