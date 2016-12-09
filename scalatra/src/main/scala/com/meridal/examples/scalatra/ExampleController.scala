package com.meridal.examples.scalatra
import org.scalatra.ScalatraServlet


class ExampleController extends ScalatraServlet {
  
  get("/") {
    "Hello world"
  }

  get("/:name") {
    val name = params.getOrElse("name", "world")
    "Hello " + name
  }
}