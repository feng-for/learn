package com.feng.pattern.decorator;

/**
 * @ClassName: ComponentAbstract
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/29 01:26
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public abstract class ComponentAbstract implements IComponent{

    private IComponent iComponent;

    public ComponentAbstract(IComponent iComponent) {
        this.iComponent = iComponent;
    }

    @Override
    public void operator() {
        this.iComponent.operator();
    }
}
