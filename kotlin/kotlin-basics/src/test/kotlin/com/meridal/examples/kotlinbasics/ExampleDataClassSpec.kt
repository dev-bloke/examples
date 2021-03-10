package com.meridal.examples.kotlinbasics

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

private const val KEY = "key"
private const val NAME = "name"
private const val DESCRIPTION = "description"
private const val OTHER_KEY = "other key"

class ExampleDataClassSpec: Spek({

    val exampleData = ExampleDataClass(KEY, NAME)

    describe ("An example data class") {

        it ("should be comparable based on its constructor parameters") {
            val other = ExampleDataClass(KEY, NAME)
            assert(other == exampleData)
            val notTheSame = ExampleDataClass(OTHER_KEY, NAME)
            assert(notTheSame != exampleData)
        }

        it ("should be comparable based on its hashcode") {
            val other = ExampleDataClass(KEY, NAME)
            assert(other.hashCode() == exampleData.hashCode())
            val notTheSame = ExampleDataClass(OTHER_KEY, NAME)
            assert(notTheSame.hashCode() != exampleData.hashCode())
        }

        it ("should not be comparable based on the description") {
            val other = ExampleDataClass(KEY, NAME)
            other.description = DESCRIPTION
            assert(other == exampleData)
        }

        it ("ignores counts that are less than zero") {
            exampleData.count = -1
            assert(exampleData.count == 0)
        }

        it ("accepts counts that are greater than zero") {
            exampleData.count = 10
            assert(exampleData.count == 10)
        }
    }
})