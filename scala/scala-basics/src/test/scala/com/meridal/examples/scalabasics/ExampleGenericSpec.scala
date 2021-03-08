package com.meridal.examples.scalabasics

import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import scala.collection.mutable.Stack
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ExampleGenericSpec extends AnyFunSpec {

  val FIRST = "one"
  val SECOND = "two"
  val THIRD = "three"

  val generic = new ExampleGeneric[String]()
  
  describe("An example generic") {

    it ("should push strings onto a stack") {
        generic.push(FIRST)
        generic.push(SECOND)
        generic.push(THIRD)
        assert(generic.peek == THIRD)
    }

    it ("should pop the top string from the stack") {
        var top = generic.pop()
        assert(top == THIRD)
        assert(generic.peek == SECOND)
    }
  }
}
