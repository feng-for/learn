package com.zhiwei.pattern.proxy.dynamicproxy.cglib;

/**
 * @ClassName: CglibTargetDemo
 * @Description:
 * @Author: wei
 * @DateTime: 2023/1/10 07:11
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class CglibTargetDemo {

    public String name(String name) {
        System.out.println("我叫" + name + "！你好！我们可以做朋友吗？");
        return name;
    }
}
