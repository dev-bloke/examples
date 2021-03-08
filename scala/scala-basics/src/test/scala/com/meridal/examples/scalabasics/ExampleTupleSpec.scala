package com.meridal.examples.scalabasics

import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import scala.collection.mutable.Stack
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ExampleTupleSpec extends AnyFunSpec {
  
    val FIRST = "one"
    val SECOND = "two"

    describe ("An example class that returns a tuple") {

        it ("should return a pair of strings in a tuple") {
            val exampleTuple = new ExampleTuple(FIRST, SECOND)
            val (first, second) = exampleTuple.getTuple()
            assert(first == FIRST)
            assert(second == SECOND)
        }
    }
}
