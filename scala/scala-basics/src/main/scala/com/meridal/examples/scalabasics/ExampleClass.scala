package com.meridal.examples.scalabasics

class ExampleClass(var key: String, var name: String) {
 
    var description: String = null

    def concat(): String = key + name
}
