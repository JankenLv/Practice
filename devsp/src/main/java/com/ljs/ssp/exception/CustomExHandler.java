package com.ljs.ssp.exception;

import com.ljs.ssp.domain.JsonData;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 功能描述：自定义异常处理类
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/10 21:45 </p>
 */
@RestControllerAdvice
public class CustomExHandler {

    @ExceptionHandler(value = Exception.class)
    public Object handlerException(Exception e) {
        return JsonData.buildError(e.getMessage());
    }

}
