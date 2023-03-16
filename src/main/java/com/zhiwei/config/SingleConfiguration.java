package com.zhiwei.config;

import com.feng.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author: <a href="mailto:hiourearth@gmail.com">Jack</a>
 * @since
 */
@Configuration
public class SingleConfiguration {

    @Bean
    public Person person(){
        return new Person();
    }

}
