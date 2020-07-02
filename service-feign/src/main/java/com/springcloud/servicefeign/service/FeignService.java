package com.springcloud.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 1.注解使用feign
 * 2.开启hystrix断路器
 */
@FeignClient(value = "eureka-service", fallback = HystrixFallbackService.class)
public interface FeignService {

    /**
     * @RequestParam指定参数，否则出现Get变Post请求
     * @param name
     * @return
     */
    @GetMapping(value = "/test")
    String getTest(@RequestParam(value = "name") String name);
}
