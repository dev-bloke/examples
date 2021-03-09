package com.meridal.examples.kotlinbasics

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ExampleClassTest {

    private val key = "hello"
    private val name = "world"

    private var exampleClass: ExampleClass? = null

    @Before
    fun setup() {
        exampleClass = ExampleClass(key, name)
    }

    @Test
    fun testAttributesAreSet() {
        assertEquals(exampleClass?.key, key)
        assertEquals(exampleClass?.name, name)
    }
}