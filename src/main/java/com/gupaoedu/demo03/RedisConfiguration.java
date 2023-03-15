package com.gupaoedu.demo03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfiguration {

    @Bean
    public GpRedisTemplate gpRedisTemplate(){
        return new GpRedisTemplate();
    }
}
