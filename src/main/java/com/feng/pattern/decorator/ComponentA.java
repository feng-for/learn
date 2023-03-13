package com.feng.pattern.decorator;

/**
 * @ClassName: ComponentA
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/29 01:28
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class ComponentA extends ComponentAbstract{
    public ComponentA(IComponent iComponent) {
        super(iComponent);
    }

    @Override
    public void operator() {
        System.out.println("我是A装饰器组件");
        super.operator();
    }
}
