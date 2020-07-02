package com.springcloud.configserver.loader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Description : 自定义资源加载，防止资源乱码
 * @Author : wsz
 * @Date: 2020-07-02 16:03
 */
@Slf4j
public class CustomPropertySourceLoader implements PropertySourceLoader {

    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml", "json", "yml", "txt"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        Properties properties=new Properties();
        InputStream inputStream=null;
        try{
            inputStream=resource.getInputStream();
            properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        }catch (IOException ioEx){
            log.error("load inputStream failed",ioEx);
            throw ioEx;
        }
        catch (Exception e){
            log.error("load inputStream failed",e);
        }finally {
            if(inputStream!=null){
                inputStream.close();
            }
        }

        List<PropertySource<?>> propertySourceList=null;
        if (!properties.isEmpty()) {
            PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource(name, properties);
            propertySourceList=  new ArrayList<>();
            propertySourceList.add(propertiesPropertySource);
        }
        return  propertySourceList;
    }
}
