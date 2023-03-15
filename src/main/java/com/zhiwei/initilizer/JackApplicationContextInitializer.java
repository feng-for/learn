package com.zhiwei.initilizer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * TODO
 *
 * @author: <a href="mailto:hiourearth@gmail.com">Jack</a>
 * @since
 */
// 我们并没有能力修改Spring Boot，我们就通过这样一种扩展机制来把想要的目标代码无缝放到Spring Boot源码启动过程中
public class JackApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext context) {
        // 把一段业务代码放到Spring Boot的启动流程中，而且是启动之前
        System.out.println("Spring Boot 构造函数正在初始化，我想记录一个日志...记录一下启动的当前时间....");
//        context.getEnvironment().getPropertySources();
    }
}












