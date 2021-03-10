package com.meridal.examples.kotlinbasics

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

private const val FIRST = "one"
private const val SECOND = "two"

class ExampleInheritanceSpec: Spek({

    val exampleInheritance = ExampleInheritance(FIRST, SECOND)

    describe ("an example inheritance") {

        it ("should inherit properties from the base class") {
            assert(exampleInheritance.first == FIRST)
            assert(exampleInheritance.second == SECOND)
        }

        it ("should have an additional property") {
            assert(exampleInheritance.third == "three")
        }
    }
})