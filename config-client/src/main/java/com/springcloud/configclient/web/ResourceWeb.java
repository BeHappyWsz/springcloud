package com.springcloud.configclient.web;

import com.springcloud.configclient.config.CustomConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : 获取配置资源
 * @Author : wsz
 * @Date: 2020-07-02 17:15
 */
@RestController
@RequestMapping(value = "config")
public class ResourceWeb{

    @Autowired
    CustomConfig customConfig;

    @GetMapping(value = "")
    public CustomConfig getConfig() {
        return customConfig.getConfig();
    }
}
