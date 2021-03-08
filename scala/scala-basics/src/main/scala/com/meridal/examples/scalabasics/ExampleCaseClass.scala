package com.meridal.examples.scalabasics

final case class ExampleCaseClass(keyc: String, namec: String) {
    var key: String = keyc
    var name: String = namec
    var description: String = null
}