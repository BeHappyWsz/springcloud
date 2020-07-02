package com.springcloud.eurekaclient2.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author : wsz
 * @Date: 2020-07-01 15:03
 */
@RestController
public class TestWeb {

    @Value("${server.port}")
    String port;

    @GetMapping(value = "/test")
    public String test(String name) {
        return port + "_" + name;
    }
}
