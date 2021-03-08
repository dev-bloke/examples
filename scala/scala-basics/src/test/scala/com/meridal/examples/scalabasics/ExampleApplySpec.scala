package com.meridal.examples.scalabasics

import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import scala.collection.mutable.Stack
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ExampleApplySpec extends AnyFunSpec {
  describe ("An example apply") {

    it ("should say hello") {
        assert(ExampleApply("world") == "Hello world")
    }

    it ("should be able to identify who has been greeted") {
        val ExampleApply(name) = "Hello world"
        assert(name == "world")
    }
  }
}
