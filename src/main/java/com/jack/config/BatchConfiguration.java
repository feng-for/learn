package com.jack.config;

import com.jack.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author: <a href="mailto:hiourearth@gmail.com">Jack</a>
 * @since
 */
@Configuration   // appContext.xml   // 配置类
@ComponentScan(basePackages = "com.jack.service")
public class BatchConfiguration {

}
