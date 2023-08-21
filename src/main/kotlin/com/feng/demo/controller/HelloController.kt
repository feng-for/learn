package com.feng.demo.controller

import com.feng.demo.pojo.UserDO
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse




@RestController
class HelloController {

    @GetMapping("/index")
    fun hello(@RequestParam age:Int): String{
        val client: HttpClient = HttpClient.newBuilder().build()
        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/accessKernel"))
            .header("Content-Type", "application/json")
            .header("token", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
            .POST(HttpRequest.BodyPublishers.ofString("10004"))
            .build()

        val response: HttpResponse<String> = client.send(request, HttpResponse.BodyHandlers.ofString())
        println(response.statusCode())
        return "your age is $age"
    }

    @PostMapping("/index")
    fun helloBody(@RequestBody name: String): String {
        return "your name is $name"
    }

    @PostMapping("/name")
    fun helloName(@RequestParam name: String): String {
        return "your name is $name"
    }

    @PostMapping("/user")
    fun helloUser(@RequestBody userDO: UserDO): String {
        return "your name is $userDO"
    }
}

operator fun String.unaryPlus(){
    if(this.isEmpty()) return
    println("----------------")
    println(this)
}

fun main(){
    + ("2")
}