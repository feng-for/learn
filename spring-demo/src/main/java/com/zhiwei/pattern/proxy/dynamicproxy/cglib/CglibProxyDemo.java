package com.zhiwei.pattern.proxy.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName: CglibProxyDemo
 * @Description:
 * @Author: wei
 * @DateTime: 2023/1/10 07:04
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class CglibProxyDemo implements MethodInterceptor {

    private Object target;

    public CglibProxyDemo(Object object) {
        this.target = object;
    }

    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
//        指定父类，也就是目标类
        enhancer.setSuperclass(this.target.getClass());
//        指定回调方法
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib running before ...");
        Object invoke = method.invoke(this.target, objects[0]);
        System.out.println("cglib running after ...");
        return invoke;
    }
}
