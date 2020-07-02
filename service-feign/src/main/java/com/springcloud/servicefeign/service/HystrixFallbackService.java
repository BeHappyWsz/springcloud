package com.springcloud.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * @Description :
 * @Author : wsz
 * @Date: 2020-07-02 10:14
 */
@Component
public class HystrixFallbackService implements FeignService {

    @Override
    public String getTest(String name) {
        return "error:" + name;
    }
}
