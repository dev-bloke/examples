package com.meridal.examples.scalatra

import org.scalatra._

class ExampleScalatraServlet extends ScalatraServlet {

  get("/") {
    views.html.hello()
  }

}
