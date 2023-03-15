package com.zhiwei.annotation;

import com.zhiwei.annotation.value.DataDemo;
import org.springframework.context.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @ClassName: AnnotationConfig
 * @Description:
 * @Author: wei
 * @DateTime: 2023/1/7 07:22
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
@Configuration
@ComponentScan
@PropertySource(value = {"classpath:application.yml"})
public class AnnotationConfig {

    @Bean
    @Profile("pro")
    public DataDemo dataDemo() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = AnnotationConfig.class.getClassLoader().getResourceAsStream("pro.yaml");
            properties.load(new BufferedReader(new InputStreamReader(inputStream)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DataDemo()
                .setAge(Integer.valueOf(properties.getProperty("profile.age")))
                .setName(properties.getProperty("profile.name"));
    }

    @Bean
    @Profile("dev")
    public DataDemo dataDemoDev() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = AnnotationConfig.class.getClassLoader().getResourceAsStream("dev.yaml");
            properties.load(new BufferedReader(new InputStreamReader(inputStream)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DataDemo()
                .setAge(Integer.valueOf(properties.getProperty("profile.age")))
                .setName(properties.getProperty("profile.name"));
    }
}
