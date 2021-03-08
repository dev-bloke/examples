package com.meridal.examples.scalabasics

object ExampleApply {

  def apply(name: String): String = {
    "Hello %s".format(name)
  }

  def unapply(greeting: String): Option[String] = {
    val words = greeting.split(" ")
    if (words.length > 1) Some(words.last) else None
  }
}
