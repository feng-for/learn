package com.zhiwei.pattern.abstractwei;

import com.zhiwei.pattern.abstractwei.color.Color;
import com.zhiwei.pattern.abstractwei.shape.Shape;

/**
 * @ClassName: AbstractFactory
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 14:40
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public interface AbstractFactory {

    Color getColor(String color);

    Shape getShape(String shape);
}
