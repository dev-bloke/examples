package com.meridal.examples.kotlinbasics

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class ExampleCollectionsSpec: Spek({

    val exampleCollections = ExampleCollections()

    describe("An example of collections") {

        it ("should be created with a list with four integers") {
            val list = exampleCollections.list
            assert(list.size == 4)
        }

        it ("should be created with a map with two entries") {
            val map = exampleCollections.map
            assert(map.size == 2)
        }

        it ("should be created with a set with four distinct entries") {
            val distinct = exampleCollections.distinct
            assert(distinct.size == 4)
        }
    }
})