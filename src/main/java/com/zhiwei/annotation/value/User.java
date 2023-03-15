package com.zhiwei.annotation.value;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Person
 * @Description:
 * @Author: wei
 * @DateTime: 2023/1/7 07:12
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
@Data
@Component
public class User {

    @Value("${name}")
    private String name;
}
