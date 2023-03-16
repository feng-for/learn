package com.zhiwei.pattern.decorator;

/**
 * @ClassName: Test
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/29 01:29
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class Test {
    public static void main(String[] args) {
        IComponent iComponent = new ComponentImpl();
        ComponentAbstract componentAbstractA = new ComponentA(iComponent);
        ComponentAbstract componentAbstractB = new ComponentB(iComponent);
        componentAbstractA.operator();
        componentAbstractB.operator();
    }
}
