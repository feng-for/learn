package com.example.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Log4j2
public class LogController {

    @GetMapping("/1")
    public void log1(){
        MDC.put("port", "8001");
        log.info("demo send message... to demo1");
        MDC.remove("port");
    }

    @GetMapping("/2")
    public void log2(){
        MDC.put("port", "8002");
        log.info("demo send message... to demo2");
        MDC.remove("port");
    }
}