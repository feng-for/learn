package com.feng.controller;

import com.feng.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author: <a href="mailto:hiourearth@gmail.com">Jack</a>
 * @since
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;


    @RequestMapping("/query")
    public void query(){
        this.orderService.query();
    }
}
