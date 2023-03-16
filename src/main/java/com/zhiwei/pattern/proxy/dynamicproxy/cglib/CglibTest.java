package com.zhiwei.pattern.proxy.dynamicproxy.cglib;

/**
 * @ClassName: CglibTest
 * @Description:
 * @Author: wei
 * @DateTime: 2023/1/10 07:12
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class CglibTest {

    public static void main(String[] args) {
        CglibTargetDemo demo = (CglibTargetDemo) new CglibProxyDemo(new CglibTargetDemo()).createProxy();
        demo.name("雏田");
    }
}
