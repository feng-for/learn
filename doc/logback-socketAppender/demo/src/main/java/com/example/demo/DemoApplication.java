package com.example.demo;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.net.SimpleSocketServer;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		/*
		 * logback 远程日志服务端启动方式，启动服务端需要注释掉 logback.xml 中客户端代码
		 */
		// ILoggerFactory iLoggerFactory = LoggerFactory.getILoggerFactory();
		// SimpleSocketServer simpleSocketServer = new SimpleSocketServer((LoggerContext) iLoggerFactory, 8080);
		SpringApplication.run(DemoApplication.class, args);
		// simpleSocketServer.start();
	}

}
