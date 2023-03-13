package com.gupaoedu.vip.proxy.staticproxy;

/**
 * Created by Tom.
 */
public class ZhangLaosan implements IPerson {

    private IPerson person;


    public ZhangLaosan(IPerson person) {
        this.person = person;
    }

    public void findLove() {
        System.out.println("张老三开始物色");
        person.findLove();
        System.out.println("开始交往");
    }

    public void findLoveOne()
    {
        System.out.println("张老三开始物色");
        person.findLoveOne();
        System.out.println("开始交往");
    }

}
