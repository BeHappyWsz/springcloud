package com.springcloud.configclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description :
 * @Author : wsz
 * @Date: 2020-07-02 20:54
 */
@Component
public class CustomConfig {


    @Value("${name}")
    String name;

    @Value("${author}")
    String author;

    @Value("${age}")
    int age;
}
