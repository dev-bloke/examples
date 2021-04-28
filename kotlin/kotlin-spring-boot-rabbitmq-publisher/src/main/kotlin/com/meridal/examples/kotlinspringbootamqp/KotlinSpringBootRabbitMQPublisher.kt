package com.meridal.examples.kotlinspringbootamqp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringBootApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringBootApplication>(*args)
}
