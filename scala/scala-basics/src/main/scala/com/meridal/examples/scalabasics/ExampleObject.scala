package com.meridal.examples.scalabasics

object ExampleObject {

  var count: Int = 0

  def create(): Int = {
      count = count + 1
      return count
  }
}
