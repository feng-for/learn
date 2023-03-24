package com.gupaoedu.listenner;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

public class WebApplicationListener implements ApplicationListener<RequestHandledEvent> {

    @Override
    public void onApplicationEvent(RequestHandledEvent applicationStartedEvent) {
        System.out.println(applicationStartedEvent.toString());
        System.out.println("ApplicationListener .... " + System.currentTimeMillis());
    }
}
