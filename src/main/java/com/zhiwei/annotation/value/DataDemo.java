package com.zhiwei.annotation.value;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName: DataDemo
 * @Description:
 * @Author: wei
 * @DateTime: 2023/1/8 07:31
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
@Data
@Accessors(chain = true)
public class DataDemo {

    private String name;

    private Integer age;
}
