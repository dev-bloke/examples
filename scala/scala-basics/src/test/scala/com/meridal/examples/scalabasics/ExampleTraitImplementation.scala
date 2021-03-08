package com.meridal.examples.scalabasics

class ExampleTraitImplementation(namec: String) extends ExampleTrait {
  
    var name: String = namec

    def sayHello(name: String): String = "Hello " + name + "!"

    def sayHello(): String = sayHello(name)
}
