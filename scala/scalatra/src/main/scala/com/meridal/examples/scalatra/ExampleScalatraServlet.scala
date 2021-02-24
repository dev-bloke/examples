package com.meridal.examples.scalatra

import org.scalatra._

class ExampleScalatraServlet extends ScalatraStack {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }
}
