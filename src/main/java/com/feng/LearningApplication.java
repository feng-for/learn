package com.feng;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: LearningApplication
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/26 23:15
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.feng", "com.gupaoedu.vip", "com.jack", "com.annotation"})
public class LearningApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(LearningApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 因为SB最终会调用callRunners，然后调用run方法
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("SB启动完成，当前时间是什么...");
    }
}
