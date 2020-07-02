package com.springcloud.configclient.config;

import com.google.common.collect.Maps;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * @Description :
 * @Author : wsz
 * @Date: 2020-07-02 20:54
 */
@Component
@Data
public class CustomConfig {

    @Value("${name}")
    String name;

    @Value("${author}")
    String author;

    @Value("${age}")
    int age;

    public Map getConfig() {
        Map data = Maps.newHashMap();
        data.put("name", name);
        data.put("age", age);
        data.put("author", author);
        return data;
    }
}
