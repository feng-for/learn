package com.feng.demo

import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.net.SimpleSocketServer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.env.Environment

@SpringBootApplication
class DemoApplication

// @Autowired
// lateinit var environment: Environment

fun main(args: Array<String>) {
	val factory = LoggerFactory.getILoggerFactory()
	val socketServer = SimpleSocketServer(factory as LoggerContext, 10004)
	runApplication<DemoApplication>(*args)
	// println(environment.getProperty("local.server.port"))
	socketServer.start()
}
