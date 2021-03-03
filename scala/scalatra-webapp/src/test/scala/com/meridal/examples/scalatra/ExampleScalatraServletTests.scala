package com.meridal.examples.scalatra

import org.scalatra.test.scalatest._

class ExampleScalatraServletTests extends ScalatraFunSuite {

  addServlet(classOf[ExampleScalatraServlet], "/*")

  test("GET / on ExampleScalatraServlet should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

}
