package com.springcloud.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description : 测试
 * @Author : wsz
 * @Date: 2020-07-02 10:00
 */
@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${serviceHost}")
    private String host;

    /**
     * 断路器hystrix + restTemplate
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallbackError")
    public String ribbonString (String name) {
        return restTemplate.getForObject(host + "/test?name=" + name, String.class);
    }

    /**
     * 处理error
     * @param name
     * @return
     */
    public String fallbackError(String name) {
        return name + ":error!!";
    }

}
