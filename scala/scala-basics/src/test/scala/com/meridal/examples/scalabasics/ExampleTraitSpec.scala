package com.meridal.examples.scalabasics

import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import scala.collection.mutable.Stack
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ExampleTraitSpec extends AnyFunSpec {

    val NAME = "World"
    val exampleTrait = new ExampleTraitImplementation("Martin")

    describe("An example trait") {

      it("should say hello to someone.") {
        assert(exampleTrait.sayHello(NAME) == "Hello World!")
      }
  }
}
