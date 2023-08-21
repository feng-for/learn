package com.feng.demo.pojo

class Dependency {
    var libs = mutableListOf<String>()
    fun implementation(lib: String) {
        libs.add(lib)
    }

    fun remove(name: String? = null): List<String> {
        // libs.removeIf{ name != null }
        libs.remove(name)
        return libs
    }
}

fun dependencies(block: Dependency.() -> Unit): List<String> {
    val dependency = Dependency()
    dependency.block()
    return dependency.libs
}

fun main(){
    val list = dependencies {
        implementation("com.huanglinqing.ll")
        implementation("com.huanglinqing.hh")
    }
    for (text in list) {
        println(text)
    }
    val dependencies = dependencies {
        remove("com.huanglinqing.ll")
    }
    dependencies.forEach { print(it) }
}