package com.zhiwei.pattern.dynimic;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DynamicProxyUtil
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/26 23:18
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class DynamicProxyUtil {

    private static final Map<Class<?>, Object> target = new HashMap<>();

    public static <T> T getTarget(T obj) throws InstantiationException, IllegalAccessException {
        Class<?> aClass = obj.getClass();
        Object tar = target.get(aClass);
        if (tar == null) {
            tar = aClass.newInstance();
            target.put(aClass, tar);
        }
        Object finalTar = tar;
        return (T) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(),
                (proxy, method, args) -> {
                    before();
                    Object invoke = method.invoke(finalTar, args);
                    after();
                    return invoke;
                });
    }

    private static void before() {
        System.out.println("第一次见面！");
    }

    private static void after() {
        System.out.println("我很喜欢你！");
    }
}
