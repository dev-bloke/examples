package com.meridal.scalabasics.spec2

import org.junit.runner._
import org.specs2.runner._
import org.specs2.mutable._

@RunWith(classOf[JUnitRunner])
class ExampleSpecification extends Specification {
  "The 'Hello world' string" should {
    "contain 11 characters" in {
      "Hello world" must have size(11)
    }
    "start with 'Hello'" in {
      "Hello world" must startWith("Hello")
    }
    "end with 'world'" in {
      "Hello world" must endWith("world")
    }
  }
}
