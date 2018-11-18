package net.xdclass.demo.controller;

import net.xdclass.demo.bean.User;
import net.xdclass.demo.domain.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 功能描述：异常测试
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/3 </p>
 */
@RestController
public class ExceptionController {

    /**
     * 模拟全局异常
     * @return
     */
    @RequestMapping(value = "/api/v1/test_ext")
    public Object index() {
        int i = 1/0;
        return new User("jankin_lv", "1000", new Date());
    }

    /**
     * 模拟自定义异常
     * @return
     */
    @RequestMapping("/api/v1/myext")
    public Object myex() {
        throw new MyException("4399","自定义异常");
    }

    /**
     * 模拟拦截器请求
     *
     * @return
     */
    @GetMapping("/api/v1/interceptor/hello")
    public Object myInterceptor() {
        System.out.println("进入controller ---> myInterceptor方法");
        throw new MyException("999","模拟拦截器拦截的方法发生异常~");
//        return "custom interceptor";
    }
}
