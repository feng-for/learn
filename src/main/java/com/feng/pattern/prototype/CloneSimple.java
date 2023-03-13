package com.feng.pattern.prototype;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: CloneSimple
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/29 02:28
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
@Data
public class CloneSimple implements Cloneable {

    private String name;

    private int age;

    private List<String> addr;

    /**
     * 浅克隆
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public CloneSimple clone() throws CloneNotSupportedException {
        return (CloneSimple) super.clone();
    }

    /**
     * 深克隆
     * @return
     */
    public CloneSimple deepClone() {
        return JSON.parseObject(JSON.toJSONString(this), CloneSimple.class);
    }
}
