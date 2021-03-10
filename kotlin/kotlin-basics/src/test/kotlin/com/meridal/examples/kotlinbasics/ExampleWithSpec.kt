package com.meridal.examples.kotlinbasics

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class ExampleWithSpec: Spek({

    describe ("an example use of with") {

        it ("should run several functions with reference to the object") {
            val exampleWith = ExampleWith()
            with (exampleWith) {
                addToX(5)
                addToY(7)
                addToX(15)
                addToY(8)
            }
            assert(exampleWith.x == 20)
            assert(exampleWith.y == 15)
        }
    }
})