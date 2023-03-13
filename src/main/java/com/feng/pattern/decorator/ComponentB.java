package com.feng.pattern.decorator;

/**
 * @ClassName: ComponentB
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/29 01:29
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class ComponentB extends ComponentAbstract{
    public ComponentB(IComponent iComponent) {
        super(iComponent);
    }

    @Override
    public void operator() {
        System.out.println("我是B装饰器组件");
        super.operator();
    }
}
