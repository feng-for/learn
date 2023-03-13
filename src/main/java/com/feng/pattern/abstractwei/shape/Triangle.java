package com.feng.pattern.abstractwei.shape;

import com.feng.pattern.abstractwei.color.Color;

/**
 * @ClassName: Red
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 14:25
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("三角形");
    }
}
