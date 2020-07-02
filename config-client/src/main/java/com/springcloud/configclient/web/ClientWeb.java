package com.springcloud.configclient.web;

import com.springcloud.configclient.config.CustomConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author : wsz
 * @Date: 2020-07-02 20:11
 */
@RestController
@RequestMapping(value = "client")
public class ClientWeb {

    @Autowired
    CustomConfig customConfig;

    @GetMapping(value = "")
    public CustomConfig getConfig() {
        return customConfig;
    }
}
