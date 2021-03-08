package com.meridal.examples.scalabasics

import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import scala.collection.mutable.Stack
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ExampleClassWithDefaultsSpec extends AnyFunSpec {

  val FIRST = "one"
  val SECOND = "two"
  val THIRD = "three"
  val OTHER_FIRST = "1"
  val OTHER_SECOND = "2"
  val OTHER_THIRD = "3"
  
  describe ("An example class with default values") {

    it ("should have default values when instantiated with no parameters") {
      val exampleWithDefaults = new ExampleClassWithDefaults()
      assert(exampleWithDefaults.first == FIRST)
      assert(exampleWithDefaults.second == SECOND)
      assert(exampleWithDefaults.third == THIRD)
    }

    it ("should have default values when instantiated with one parameter") {
      val exampleWithDefaults = new ExampleClassWithDefaults(first = OTHER_FIRST)
      assert(exampleWithDefaults.first == OTHER_FIRST)
      assert(exampleWithDefaults.second == SECOND)
      assert(exampleWithDefaults.third == THIRD)
    }

    it ("should have no default values when instantiated with a full definition") {
      val exampleWithDefaults = new ExampleClassWithDefaults(OTHER_FIRST, OTHER_SECOND)
      exampleWithDefaults.third = OTHER_THIRD
      assert(exampleWithDefaults.first == OTHER_FIRST)
      assert(exampleWithDefaults.second == OTHER_SECOND)
      assert(exampleWithDefaults.third == OTHER_THIRD)
    }
  }
}
