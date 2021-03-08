package com.meridal.examples.scalabasics

class ExampleStaticMethods(var name: String) {
  import ExampleStaticMethods._

  def sayHello(): String = HELLO + " " + name + "!"
}

object ExampleStaticMethods {

  private val HELLO = "Hello"
  private val GOODBYE = "Goodbye"

  def waveGoodbye(someone: String): String = GOODBYE + " " + someone + "!"
}
