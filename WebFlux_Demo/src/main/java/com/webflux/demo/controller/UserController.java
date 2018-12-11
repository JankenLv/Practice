package com.webflux.demo.controller;

import com.webflux.demo.model.User;
import com.webflux.demo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * 功能描述：TODO
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/12/11 22:13 </p>
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 功能描述：获取用户
     * @param id
     * @return
     */
    @GetMapping("get")
    public Mono<User> get(String id) {
        return userService.getUser(id);
    }

    /**
     * 功能描述：删除用户
     * @param id
     * @return
     */
    @GetMapping("del")
    public Mono<User> del(String id) {
        return userService.delUser(id);
    }

    /**
     * 功能描述：获取所有用户
     * @param
     * @return
     */
    @GetMapping(value = "list",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> list() {
        return userService.getList().delayElements(Duration.ofSeconds(2));
    }

}
