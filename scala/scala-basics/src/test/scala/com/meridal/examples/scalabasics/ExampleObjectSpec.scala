package com.meridal.examples.scalabasics

import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import scala.collection.mutable.Stack
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ExampleObjectSpec extends AnyFunSpec {
  describe("An example object") {
      it("should return an incremented integer when create is called") {
          val first = ExampleObject.create()
          val second = ExampleObject.create()
          assert(first == 1)
          assert(second == 2)
      }
  }
}
