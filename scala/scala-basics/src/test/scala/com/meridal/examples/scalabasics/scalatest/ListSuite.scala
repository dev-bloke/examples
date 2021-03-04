package com.meridal.examples.scalabasics.scalatest

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner
@RunWith(classOf[JUnitRunner])
class ListSuite extends AnyFunSuite with Matchers {

  test("An empty list should be empty") {
    List() should be (Symbol("empty"))
    Nil should be (Symbol("empty"))
  }

  test("A non-empty list should not be empty") {
    List(1, 2, 3) should not be (Symbol("empty"))
    List("fee", "fie", "foe", "fum") should not be (Symbol("empty"))
  }

  test("A list's length should equal the number of elements it contains") {
    List() should have length (0)
    List(1, 2) should have length (2)
    List("fee", "fie", "foe", "fum") should have length (4)
  }
}