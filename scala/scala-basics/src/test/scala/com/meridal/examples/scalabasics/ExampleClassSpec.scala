package com.meridal.examples.scalabasics

import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import scala.collection.mutable.Stack
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ExampleClassSpec extends AnyFunSpec {

  val KEY = "key"
  val NAME = "name"
  val DESCRIPTION = "description"
  val exampleClass = new ExampleClass(KEY, NAME)

  describe("an example class") {

    it ("should retain constructor parameters") {    
      assert(exampleClass.key == KEY)
      assert(exampleClass.name == NAME)
    }

    it ("should concatenate the two constructor parameters") {
      assert(exampleClass.concat() == KEY + NAME)
    }

    it ("should be created with no description set.") {
      assert(exampleClass.description == null)
    }

    it ("should retain any description set after instantiation") {
      exampleClass.description = DESCRIPTION
      assert(exampleClass.description == DESCRIPTION)
    }
  }
}
