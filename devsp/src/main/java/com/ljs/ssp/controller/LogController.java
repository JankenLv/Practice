package com.ljs.ssp.controller;

import com.ljs.ssp.domain.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：日志输出控制器
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/13 8:25 </p>
 */
@RestController
@RequestMapping("/api/v1/log")
public class LogController {

    private static final Logger log = LoggerFactory.getLogger(LogController.class);

    @GetMapping("test_log")
    public JsonData showLog() {
        log.info("这是info日志");
        log.warn("这是warn日志");
        log.debug("这是debug日志");
        log.error("这是error日志");

        return JsonData.buildSuccess("ok");
    }

}
