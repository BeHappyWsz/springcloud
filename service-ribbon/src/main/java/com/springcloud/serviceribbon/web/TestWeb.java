package com.springcloud.serviceribbon.web;

import com.springcloud.serviceribbon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description :
 * @Author : wsz
 * @Date: 2020-07-01 15:47
 */
@RestController
public class TestWeb {

    @Autowired
    TestService testService;

    /**
     * 注册2个同名的服务，自动负载均衡请求不同的服务端口
     * @param name
     * @return
     */
    @GetMapping(value = "/ribbon")
    public String ribbon (String name) {
        return testService.ribbonString(name);
    }
}
