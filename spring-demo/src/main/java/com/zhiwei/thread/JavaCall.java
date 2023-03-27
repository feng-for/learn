package com.zhiwei.thread;

public class JavaCall {

    public void callBack(String name, Call call) {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            call.callBack(name);
        }).start();
    }

    public static void main(String[] args) {
        JavaCall javaCall = new JavaCall();
        javaCall.callBack("雏田", System.out::println);
        System.out.println("我是主线程");
    }
}
