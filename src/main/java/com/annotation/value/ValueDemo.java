package com.annotation.value;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @ClassName: VauleDemo
 * @Description:
 * @Author: wei
 * @DateTime: 2023/1/7 07:05
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
@Data
@Component
public class ValueDemo {

    @Value("#{user.getName()}")
    private String name;

    @Value("${age}")
    private Integer age;

    @Value("${sex}")
    private String sex;

    @Value("#{systemProperties['os.name']}")
    private String os;

    @Value("classpath:feng.properties")
    private Resource file;

    @Value("https://wwww.baidu.com")
    private Resource web;
}
