package com.zhiwei.config.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: ConfigurationIOC
 * @Description:
 * @Author: wei
 * @DateTime: 2023/1/5 23:44
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
@Configuration
public class ConfigurationIoc {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public IocLearn iocLearn() {
        return new IocLearn();
    }

}
