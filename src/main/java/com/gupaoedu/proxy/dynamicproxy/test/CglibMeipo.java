package com.gupaoedu.proxy.dynamicproxy.test;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMeipo implements MethodInterceptor {

    /**
     * Cglib创建代理对象的一个类库
     * @param clazz
     * @return
     */
    public Object getInstance(Class<?> clazz){
        /**
         * clazz要求目标不需要继承实现任何的接口，是个独立的类就好了
         * 可以根据这个clazz拿到这个类底下所有的方法
         * 然后会生成一个类去继承他一个方法
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o,objects);
        after();
        return result;
    }

    private void after() {
        System.out.println("双方同意开始交往");
    }

    private void before() {
        System.out.println("我是媒婆，已经收集到你的需求，开始物色");
    }
}
