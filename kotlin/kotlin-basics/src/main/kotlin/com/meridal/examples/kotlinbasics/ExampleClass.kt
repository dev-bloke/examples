package com.meridal.examples.kotlinbasics

class ExampleClass(var key: String, var name: String) {
 
    var description: String? = null

    fun concat(): String = key + name
}