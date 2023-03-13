package com.gupaoedu.vip.spidemo;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author 帅气的景天老师
 * @create 2022/6/8 18:01
 */
public class TestSPI {
    public static void main(String[] args) {
//        Iterator<SPIService> providers = Service.providers(SPIService.class);
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);

//        while(providers.hasNext()) {
//            SPIService ser = providers.next();
//            ser.doSomething();
//        }
//        System.out.println("--------------------------------");
        Iterator<SPIService> iterator = load.iterator();
        while(iterator.hasNext()) {
            SPIService ser = iterator.next();
            ser.doSomething();
        }
//        for(SPIService db:load){
//            db.doSomething();
//        }
    }
}
