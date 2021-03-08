package com.meridal.examples.scalabasics

class ExampleGeneric[A] {

  private var elements: List[A] = Nil

  def push(element: A): Unit = {
    elements = element :: elements
  }

  def peek: A = elements.head

  def pop(): A = {
    val top = peek
    elements = elements.tail
    top
  }
}
