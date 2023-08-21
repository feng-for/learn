package com.feng.demo.pojo

open class P() {

    constructor(name: String, age: Int) : this() {
        print("I am parent $name, age is $age\n")
    }

    constructor(name: String, age: Int, boolean: Boolean): this() {
        print("I am parent $name, age is $age, I $boolean\n")
    }
}