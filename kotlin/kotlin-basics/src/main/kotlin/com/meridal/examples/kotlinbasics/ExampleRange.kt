package com.meridal.examples.kotlinbasics

object ExampleRange {
    fun getValueBasedOnRange(number: Int) = when (number) {
        in 1..10 -> {
            "Between 1 and 10"
        }
        in 11..20 -> {
            "Between 11 and 20"
        }
        else -> {
            "Not between 1 and 20"
        }
    }
}