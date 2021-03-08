package com.meridal.examples.scalabasics

class ExampleMixin(key: String, name: String) extends ExampleClass(key, name) with ExampleTrait {
  
    def sayHello(name: String): String = "Hello " + name + "!"
}
