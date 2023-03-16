package com.zhiwei.pattern.dynimic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @ClassName: DynamicProxyUtil
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/26 23:18
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class DynamicProxy2Util<T> implements InvocationHandler {

    private T target;

    public T getTarget(T userService) {
        this.target = userService;
        Class<?> aClass = userService.getClass();
        Object o = Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
        return (T) o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        System.out.println(method);
        System.out.println(Arrays.toString(args));
        Object invoke = method.invoke(this.target, args);
        after();
        return invoke;
    }

    private void before() {
        System.out.println("第一次见面！");
    }

    private void after() {
        System.out.println("我很喜欢你！");
    }
}
