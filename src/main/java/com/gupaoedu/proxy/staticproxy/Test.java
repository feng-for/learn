package com.gupaoedu.proxy.staticproxy;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        ZhangLaosan zhangLaosan = new ZhangLaosan(new ZhaoLiu());
        zhangLaosan.findLove();
    }
}
