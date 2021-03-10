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

    fun getValuesBasedOnRange(number: Int) = when (number) {
        in 1..10 -> {
            Pair("positive", "Between 1 and 10")
        }
        in 11..20 -> {
            Pair("positive", "Between 11 and 20")
        }
        0 -> {
            Pair("zero", "Zero")
        }
        else -> {
            Pair("unknown", "Not between 0 and 20")
        }
    }
}