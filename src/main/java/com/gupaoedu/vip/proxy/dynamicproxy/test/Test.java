package com.gupaoedu.vip.proxy.dynamicproxy.test;

public class Test {
    public static void main(String[] args) {
        Zhangsan zhangsan = (Zhangsan) new CglibMeipo().getInstance(Zhangsan.class);
        zhangsan.findLove();

    }
}
