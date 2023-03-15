package com.gupaoedu.demo04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfiguration {

    @Bean
    public GpSqlSessionFactory gpSqlSessionFactory(){
        return new GpSqlSessionFactory();
    }
}
