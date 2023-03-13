package com.gupaoedu.vip.listenner;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class StarterApplicationListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println(applicationStartedEvent.toString());
        System.out.println("ApplicationListener .... " + System.currentTimeMillis());
    }
}
