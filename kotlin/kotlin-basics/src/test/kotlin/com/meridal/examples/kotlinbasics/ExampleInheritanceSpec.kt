package com.meridal.examples.kotlinbasics

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

private const val FIRST = "one"
private const val SECOND = "two"
private const val THIRD = "three"

class ExampleInheritanceSpec: Spek({

    val exampleInheritance = ExampleInheritance(FIRST, SECOND)

    describe ("an example inheritance") {

        it ("should inherit properties from the base class") {
            assert(exampleInheritance.first == FIRST)
            assert(exampleInheritance.second == SECOND)
        }

        it ("should have an additional property") {
            assert(exampleInheritance.third == THIRD)
        }

        it ("should have an overridden function") {
            assert(exampleInheritance.concatWithSpaceDelimiter() == "$FIRST $SECOND $THIRD")
        }
    }
})