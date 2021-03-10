package com.meridal.examples.kotlinbasics

object ExampleSmartCast {

    fun getStringLength(obj: Any) = if (obj is String) obj.length else -1
}