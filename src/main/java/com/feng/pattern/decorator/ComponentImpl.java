package com.feng.pattern.decorator;

/**
 * @ClassName: ComponentImpl
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/29 01:25
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class ComponentImpl implements IComponent{
    @Override
    public void operator() {
        System.out.println("具体组件！");
    }
}
