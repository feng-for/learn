package com.gupaoedu.redisson;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 帅气的景天老师
 * @create 2021/8/11 11:05
 */
// @ConditionalOnClass(Redisson.class)//条件装配
@EnableConfigurationProperties(RedissonProperties.class)
@Configuration
public class RedissonAutoConfiguration {

    // @Bean
    // RedissonClient redissonClient(RedissonProperties redissonProperties){
    //     Config config = new Config();
    //     String prefix="redis://";
    //     if (redissonProperties.isSsl()){
    //         prefix="rediss://";
    //     }
    //     config.useSingleServer()
    //             .setAddress(prefix+redissonProperties.getHost()+":"+redissonProperties.getPort())
    //             .setDatabase(redissonProperties.getDatasource())
    //             .setConnectTimeout(redissonProperties.getTimeout());
    //
    //     return Redisson.create(config);
    // }
}
