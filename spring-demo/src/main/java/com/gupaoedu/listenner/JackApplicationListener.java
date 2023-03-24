package com.gupaoedu.listenner;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * TODO
 *
 * @author: <a href="mailto:hiourearth@gmail.com">Jack</a>
 * @since
 */
public class JackApplicationListener implements ApplicationListener<ApplicationStartingEvent> {


    // 如果Spring Boot启动的过程中发布了这个类型的事件ApplicationStartingEvent，那么就会回调到这个方法，也是一种Spring Boot扩展代码的机制
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("haha...");

    }
}
