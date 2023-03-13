package com.gupaoedu.vip.proxy.dynamicproxy.cglibproxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;

/**
 * Created by Tom on 2019/3/11.
 */
public class CGlib2Meipo {


    public static <T> T getInstance(Class<T> clazz){
        //相当于Proxy，代理的工具类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            before();
            Object obj = methodProxy.invokeSuper(o,objects);
            after();
            return obj;
        });
        return (T) enhancer.create();
    }

    private static void before(){
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
    }

    private static void after(){
        System.out.println("OK的话，准备办事");
    }
}
