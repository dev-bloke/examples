package com.meridal.examples.scalabasics

import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import scala.collection.mutable.Stack
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ExampleStaticMethodsSpec extends AnyFunSpec {

  val HELLO = "World"
  val GOODBYE = "Everybody"
  
  describe ("An example of static methods") {

    it ("should say hello") {
        var exampleStatic = new ExampleStaticMethods(HELLO)
        assert(exampleStatic.sayHello() == "Hello World!")
    }

    it ("should wave goodbye") {
        assert(ExampleStaticMethods.waveGoodbye(GOODBYE) == "Goodbye Everybody!")
    }
  }
}
