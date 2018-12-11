package com.webflux.demo.service;

import com.webflux.demo.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：user业务类
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/12/11 22:01 </p>
 */
@Service
public class UserService {

    private static final Map<String, User> userData = new HashMap<>();

    static{
        userData.put("1",new User("01","小X课堂"));
        userData.put("2",new User("02","小D课堂"));
        userData.put("3",new User("03","小C课堂"));
        userData.put("4",new User("04","小L课堂"));
        userData.put("5",new User("05","小A课堂"));
        userData.put("6",new User("06","小S课堂"));
        userData.put("7",new User("07","小S课堂"));
    }

    public Mono<User> getUser(String id) {
        return Mono.justOrEmpty(UserService.userData.get(id));
    }

    public Mono<User> delUser(String id) {
        return Mono.justOrEmpty(UserService.userData.remove(id));
    }

    public Flux<User> getList() {
        return Flux.fromIterable(UserService.userData.values());
    }

}
