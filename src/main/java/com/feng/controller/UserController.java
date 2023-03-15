package com.feng.controller;

import com.zhiwei.annotation.value.ValueDemo;
import com.feng.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: UserController
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 09:15
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private ValueDemo valueDemo;

    @GetMapping("/test")
    public String test() {
        String name = "雏田";
        userService.say(name);
        userService.sleep(name);
        return "Hello World!!!";
    }

    @GetMapping("/test1")
    public String test1() {
        return valueDemo.toString();
    }
}
