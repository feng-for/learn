package com.gupaoedu.vip.listenner;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.MutablePropertySources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class MyPropertySourceListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {

        MutablePropertySources destination = event.getEnvironment().getPropertySources();
        Properties properties = new Properties();
        try {
            InputStream in = MyPropertySourceListener.class.getClassLoader().getResourceAsStream("feng.properties");
            properties.load(in);
//            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
//                ch.put(entry.getKey(),entry.getValue());
//            }
            ConcurrentHashMap<Object, Object> ch = new ConcurrentHashMap<>(properties);
            OriginTrackedMapPropertySource source = new OriginTrackedMapPropertySource("feng.properties",ch);
            destination.addLast(source);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
