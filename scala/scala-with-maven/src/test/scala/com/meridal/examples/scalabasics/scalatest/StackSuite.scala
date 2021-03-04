package com.meridal.examples.scalabasics.scalatest

import scala.collection.mutable.Stack
import org.scalatest.Assertions
import org.junit.Test

class StackSuite extends Assertions {

  @Test def stackShouldPopValuesIinLastInFirstOutOrder: Unit = {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }

  @Test def stackShouldThrowNoSuchElementExceptionIfAnEmptyStackIsPopped: Unit = {
    val emptyStack = new Stack[String]
    intercept[NoSuchElementException] {
      emptyStack.pop()
    }
  }
}