package com.meridal.examples.kotlinbasics

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class ExampleRangeSpec: Spek({

    describe ("An example range") {

        it ("should detect a number between one and ten") {
            assert(ExampleRange.getValueBasedOnRange(5) == "Between 1 and 10")
        }

        it ("should detect a number between eleven and twenty") {
            assert(ExampleRange.getValueBasedOnRange(17) == "Between 11 and 20")
        }

        it ("should detect a positive number that is not between one and twenty") {
            assert(ExampleRange.getValueBasedOnRange(30) == "Not between 1 and 20")
        }

        it ("should detect a negative number that is not between one and twenty") {
            assert(ExampleRange.getValueBasedOnRange(-7) == "Not between 1 and 20")
        }

        it ("should detect that zero is not between one and twenty") {
            assert(ExampleRange.getValueBasedOnRange(0) == "Not between 1 and 20")
        }
    }
})