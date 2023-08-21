package com.feng.demo.pojo

class C : P {

    constructor()

    constructor(name: String, age:Int): super(name, age)

    constructor(name: String, age: Int, boolean: Boolean): super(name, age, boolean)
}

fun main(){
    print(C("雏田", 18))
}