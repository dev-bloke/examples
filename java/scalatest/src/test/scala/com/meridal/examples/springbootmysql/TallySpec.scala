package com.meridal.examples.springbootmysql

import org.scalatest._

/**
 * Test specification for the {@link Tally} component.
 * @author Martin Ingram
 */
class TallySpec extends FlatSpec with Matchers {
  
  "A Tally" should "return zero when there has been no addition or subtraction for a category" in {
    val tally = new Tally()
    tally.getTotal("test") should be (0)
  }
  
  it should "keep a running total of all additions for a category" in {
    val category = "test"
    val tally = new Tally()
    tally.add(category, 1)
    tally.add(category, 2)
    tally.add(category, 3)
    tally.getTotal(category) should be (6)
  }
  
  it should "subtract values from a running total for a category" in {
    val category = "test"
    val tally = new Tally()
    tally.add(category, 1)
    tally.add(category, 2)
    tally.add(category, 3)
    tally.subtract(category, 4)
    tally.getTotal(category) should be (2)    
  }
  
  it should "handle negative totals for a category" in {
    val category = "test"
    val tally = new Tally()
    tally.add(category, 1)
    tally.add(category, 2)
    tally.subtract(category, 4)
    tally.getTotal(category) should be (-1)    
  }
 

  it should "throw an IllegalArgumentException if a null value is added" in {
    val tally = new Tally()
    val nullInt: Integer = null;
    a [IllegalArgumentException] should be thrownBy {
      tally.add("test", nullInt)
    }
  }
}