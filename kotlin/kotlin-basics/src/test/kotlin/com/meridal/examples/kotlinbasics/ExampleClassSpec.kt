package com.meridal.examples.kotlinbasics

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

private const val KEY = "key"
private const val NAME = "name"
private const val DESCRIPTION = "description"

class ExampleClassSpec: Spek ({

    val exampleClass = ExampleClass(KEY, NAME)

    describe ("An example class") {

        it ("should retain constructor parameters") {
            assert(exampleClass.key == KEY)
            assert(exampleClass.name == NAME)
        }

        it ("should concatenate the two constructor parameters") {
            assert(exampleClass.concat() == KEY + NAME)
        }

        it ("should be created with no description set.") {
            assert(exampleClass.description == null)
        }

        it ("should retain any description set after instantiation") {
            exampleClass.description = DESCRIPTION
            assert(exampleClass.description == DESCRIPTION)
        }
    }
})