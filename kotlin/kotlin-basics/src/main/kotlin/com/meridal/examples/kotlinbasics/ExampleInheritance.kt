package com.meridal.examples.kotlinbasics

class ExampleInheritance(first: String, second: String): ExampleBaseClass(first, second) {

    var third: String = "three"

    override fun concatWithSpaceDelimiter() = "$first $second $third"
}