package com.meridal.examples.kotlinbasics

open class ExampleBaseClass (var first: String, var second: String) {

    open fun concatWithSpaceDelimiter() = "$first $second"
}