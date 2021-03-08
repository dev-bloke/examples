package com.meridal.examples.scalabasics

class ExampleClass(keyc: String, namec: String) {
    var key: String = keyc
    var name: String = namec
    var description: String = null

    def concat(): String = key + name
}
