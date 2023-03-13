package com.feng.service.impl;

import com.feng.pattern.TemplatePattern;
import com.feng.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/26 23:20
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void say(String name) {
        System.out.println("你好！我是"+name+"！");
    }

    @Override
    public void one(String name) {
        System.out.println(name + "，第一天，我们去看电影吧！");
    }

    @Override
    public void two(String name) {
        System.out.println(name + "，第二天，我们去海洋馆吧！");
    }

    @Override
    public void three(String name) {
        System.out.println(name + "，第三天，我们去逛街吧！");
    }

    @Override
    public void four(String name) {
        System.out.println(name + "，第四天，我们去看日出吧！");
    }
}
