package net.xdclass.demo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义全局异常捕获类
 */
@RestControllerAdvice
public class CustomExHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomExHandler.class);

    // 捕获全局异常，处理所有不可知异常
    @ExceptionHandler(value = Exception.class)
//    @RequestBody  // 使用@RestControllerAdvice就不用使用该注解
    Object handlerException(Exception e, HttpServletRequest request) {
        LOG.error("url: {} ; msg: {}", request.getRequestURI(), e.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("msg",e.getMessage());
        map.put("url", request.getRequestURI());
        return map;
    }

    /**
     * 功能描述：捕获自定义异常
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    Object handlerMyException(MyException e, HttpServletRequest request) {
        // 进行页面跳转
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg",e.getMessage());
        return modelAndView;*/

        // 返回json数据，由前端去判断加载什么页面
        Map<String, Object> map = new HashMap<>();
        map.put("code", e.getCode());
        map.put("msg",e.getMsg());
        map.put("url", request.getRequestURI());
        return map;
    }


}
