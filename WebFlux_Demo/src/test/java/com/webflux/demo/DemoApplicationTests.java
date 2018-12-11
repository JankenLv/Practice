package com.webflux.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class DemoApplicationTests {

    @Test
    public void testGetUser() {
        Mono<String> mono = WebClient.create().get()
            .uri("http://localhost:8080/api/v1/user/get?id={id}", "5")
            .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class);
        System.out.println("====>>测试结果：" + mono.block());
    }

}
