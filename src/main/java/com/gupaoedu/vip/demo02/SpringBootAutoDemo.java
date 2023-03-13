package com.gupaoedu.vip.demo02;

import com.gupaoedu.vip.demo03.GpRedisTemplate;
import com.gupaoedu.vip.demo04.GpSqlSessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableMyConfiguration
@SpringBootApplication
public class SpringBootAutoDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootAutoDemo.class, args);
        System.out.println(context.getBean(GpRedisTemplate.class));
        System.out.println(context.getBean(GpSqlSessionFactory.class));
    }
}
