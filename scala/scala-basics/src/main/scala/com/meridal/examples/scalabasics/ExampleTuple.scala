package com.meridal.examples.scalabasics

class ExampleTuple(var first: String, var second: String) {
  
    def getTuple(): Tuple2[String, String] = (first, second)
}
