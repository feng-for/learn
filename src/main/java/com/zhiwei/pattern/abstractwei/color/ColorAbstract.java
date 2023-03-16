package com.zhiwei.pattern.abstractwei.color;

import com.zhiwei.pattern.abstractwei.shape.Shape;

import javax.el.MethodNotFoundException;

/**
 * @ClassName: ColorAbstract
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 14:43
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public abstract class ColorAbstract {

    public Shape getShape(String shape){
        throw new MethodNotFoundException("父类方法没有实现，需要子类实现！");
    };
}
