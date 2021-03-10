package com.meridal.examples.kotlinbasics

data class ExampleDataClass(val key: String, val name: String) {
    var description: String? = null
    var count = 0
        set(value) {
            if (value >= 0) field = value
        }
}