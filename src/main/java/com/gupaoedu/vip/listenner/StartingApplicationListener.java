package com.gupaoedu.vip.listenner;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class StartingApplicationListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartedEvent) {
        System.out.println(applicationStartedEvent.toString());
        System.out.println("ApplicationListener .... " + System.currentTimeMillis());
    }
}
