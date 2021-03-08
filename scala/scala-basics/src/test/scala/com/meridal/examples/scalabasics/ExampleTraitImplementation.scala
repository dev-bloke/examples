package com.meridal.examples.scalabasics

class ExampleTraitImplementation(var name: String) extends ExampleTrait {
  
    def sayHello(name: String): String = "Hello " + name + "!"

    def sayHello(): String = sayHello(name)
}
