package com.meridal.examples.scalabasics

class ExampleClass(var key: String, var name: String) {
 
    var description: String? = null

    fun concat(): String = key + name
}