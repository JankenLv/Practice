package net.xdclass.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//测试http协议的get请求
@RestController
public class GetController {

    private Map<String,String> params = new HashMap<>();

//    @Autowired
//    private AcmeProperties acmeProperties;

    /**
     * 功能描述：测试restful协议，从路径中获取字段
     * @param cityId
     * @param userId
     * @return
     */
//    @RequestMapping(path = "/{city_id}/{user_id}",method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id") String cityId,@PathVariable("user_id")  String userId) {
        params.clear();
        params.put("cityId",cityId);
        params.put("userId",userId);

        return params;
    }

    /**
     * 功能描述：测试@RequestHeader注解
     * @param access_token
     * @return
     */
    @GetMapping("/testHeader")
    public Object testHeader(@RequestHeader("access_token") String access_token) {
        params.clear();
        params.put("access_token",access_token);
        return params;
    }

    /**
     * 加载自定义属性到Bean
     * @return
     */
//    @GetMapping("custom_properties")
//    public Object getAcmeProperties() {
//        return acmeProperties;
//    }
}
