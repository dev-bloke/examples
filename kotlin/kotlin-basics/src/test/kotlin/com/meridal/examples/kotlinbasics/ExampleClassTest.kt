package com.meridal.examples.kotlinbasics

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ExampleClassTest {

    companion object {
        const val KEY = "hello"
        const val NAME = "world"
    }

    private var exampleClass: ExampleClass? = null

    @Before
    fun setup() {
        exampleClass = ExampleClass(KEY, NAME)
    }

    @Test
    fun testAttributesAreSet() {
        assertEquals(exampleClass?.key, KEY)
        assertEquals(exampleClass?.name, NAME)
    }
}
