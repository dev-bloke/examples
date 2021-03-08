package com.meridal.examples.scalabasics

import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import scala.collection.mutable.Stack
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ExampleCaseClassSpec extends AnyFunSpec {

  val KEY = "key"
  val NAME = "name"
  val DESCRIPTION = "description"
  val OTHER_KEY = "other key"
  val exampleCase = ExampleCaseClass(KEY, NAME)

  describe("an example case class") {

    it ("should be comparable based on its constructor parameters") {    
      val other = ExampleCaseClass(KEY, NAME)
      assert(other == exampleCase)
      val notTheSame = ExampleCaseClass(OTHER_KEY, NAME)
      assert(notTheSame != exampleCase)
    }

    it ("should not be comparable based on the description") {
      val other = ExampleCaseClass(KEY, NAME)
      other.description = DESCRIPTION
      assert(other == exampleCase)
    }
  }  
}
