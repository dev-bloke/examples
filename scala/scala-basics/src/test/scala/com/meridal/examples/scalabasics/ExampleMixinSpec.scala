package com.meridal.examples.scalabasics

import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import scala.collection.mutable.Stack
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ExampleMixinSpec extends AnyFunSpec {
  
  val KEY = "key"
  val NAME = "name"
  val DESCRIPTION = "description"
  val OTHER_NAME = "World"
  val exampleMixin = new ExampleMixin(KEY, NAME)

  describe ("An example mixin") {

    it ("should retain constructor parameters") {    
      assert(exampleMixin.key == KEY)
      assert(exampleMixin.name == NAME)
    }

    it ("should concatenate the two constructor parameters") {
      assert(exampleMixin.concat() == KEY + NAME)
    }

    it ("should be created with no description set.") {
      assert(exampleMixin.description == null)
    }

    it ("should retain any description set after instantiation") {
      exampleMixin.description = DESCRIPTION
      assert(exampleMixin.description == DESCRIPTION)
    }

    it("should say hello to someone.") {
      assert(exampleMixin.sayHello(OTHER_NAME) == "Hello World!")
    }
  }
}
