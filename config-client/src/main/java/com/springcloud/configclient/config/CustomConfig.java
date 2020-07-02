package com.springcloud.configclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description : 配置文件读取类
 * @Author : wsz
 * @Date: 2020-07-02 17:16
 */
@Component
public class CustomConfig {

    @Value("${server.name}")
    public String name;

    @Value("${author}")
    public String author;

    public CustomConfig getConfig() {
        return this;
    }
}
