package com.meridal.examples.kotlinbasics

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class ExampleSmartCastSpec: Spek({

    describe ("an example smart cast") {

        it ("should calculate a string length if supplied with a string") {
            assert(ExampleSmartCast.getStringLength("Hello") == 5)
        }

        it ("should return minus one for any parameter that isn't a string") {
            val list = listOf("A", "B", "C")
            assert(ExampleSmartCast.getStringLength(list) == -1)
        }
    }
})