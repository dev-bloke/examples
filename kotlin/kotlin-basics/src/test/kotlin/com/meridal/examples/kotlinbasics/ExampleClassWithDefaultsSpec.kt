package com.meridal.examples.kotlinbasics

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

private const val FIRST = "one"
private const val SECOND = "two"
private const val THIRD = "three"
private const val OTHER_FIRST = "1"
private const val OTHER_SECOND = "2"
private const val OTHER_THIRD = "3"

class ExampleClassWithDefaultsSpec: Spek({

    describe ("An example class with default values") {

        it ("should have default values when instantiated with no parameters") {
            val exampleWithDefaults = ExampleClassWithDefaults()
            assert(exampleWithDefaults.first == FIRST)
            assert(exampleWithDefaults.second == SECOND)
            assert(exampleWithDefaults.third == THIRD)
        }

        it ("should have default values when instantiated with one parameter") {
            val exampleWithDefaults = ExampleClassWithDefaults(first = OTHER_FIRST)
            assert(exampleWithDefaults.first == OTHER_FIRST)
            assert(exampleWithDefaults.second == SECOND)
            assert(exampleWithDefaults.third == THIRD)
        }

        it ("should have no default values when instantiated with a full definition") {
            val exampleWithDefaults = ExampleClassWithDefaults(OTHER_FIRST, OTHER_SECOND)
            exampleWithDefaults.third = OTHER_THIRD
            assert(exampleWithDefaults.first == OTHER_FIRST)
            assert(exampleWithDefaults.second == OTHER_SECOND)
            assert(exampleWithDefaults.third == OTHER_THIRD)
        }
    }
})