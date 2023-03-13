package com.feng.ioc;

/**
 * @ClassName: IocLearn
 * @Description:
 * @Author: wei
 * @DateTime: 2023/1/5 23:42
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class IocLearn {

    public void string() {
        System.out.println("IOC ...");
    }

    private void init() {
        System.out.println("init ....");
    }

    private void destroy() {
        System.out.println("destroy ....");
    }
}
