package com.meridal.examples.scalaspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication

@SpringBootApplication
class ScalaSpringBootApplication

object ScalaSpringBootApplication {
  
  def main(args: Array[String]): Unit = SpringApplication.run(classOf[ScalaSpringBootApplication])
}
