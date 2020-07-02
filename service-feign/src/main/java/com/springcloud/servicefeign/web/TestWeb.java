package com.springcloud.servicefeign.web;

import com.springcloud.servicefeign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author : wsz
 * @Date: 2020-07-02 09:32
 */
@RestController
@RequestMapping(value = "feign")
public class TestWeb {

    @Autowired
    FeignService feignService;

    @GetMapping(value = "")
    public String feignTest(String name) {
        return feignService.getTest(name);
    }
}
