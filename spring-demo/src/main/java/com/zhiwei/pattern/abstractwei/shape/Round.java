package com.zhiwei.pattern.abstractwei.shape;

/**
 * @ClassName: Red
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 14:25
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class Round implements Shape {
    @Override
    public void draw() {
        System.out.println("圆形");
    }
}
