package com.meridal.examples.kotlinbasics

/* The example using with is in the associated test. */
class ExampleWith(var x: Int = 0, var y: Int = 0) {
    fun addToX(dx: Int) {
        x += dx
    }

    fun addToY(dy: Int) {
        y += dy
    }
}