package com.meridal.examples.springbootmysql;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class CalculatorTest {
    
    private static int START = 1;
    
    private Calculator calculator;
    
    @BeforeMethod
    public void setup() {           
        this.calculator = new Calculator(START);
    }
    
    @Test
    public void testConstructor() {
        assertNotNull(this.calculator.getValue());
        assert this.calculator.getValue() == (START);
        assertEquals(START, this.calculator.getValue());
    }
    
    @Test(dataProvider = "example-add")
    public void testAdd(Integer i) {
        this.calculator.add(i);
        assertEquals(START + i, this.calculator.getValue());
    }
    
    @DataProvider(name="example-add")
    public Object[][] exampleAddProvider() {
        return new Object[][] { 
            { 10 } 
        };      
    }
    
    @Test(dataProvider = "example-add-with-result")
    public void testAddWithResult(int i, int result) {
        this.calculator.add(i);
        assertEquals(result, this.calculator.getValue());
    }
    
    @DataProvider(name="example-add-with-result")
    public Object[][] exampleAddWithResultProvider() {
        return new Object[][] { 
            { 1, 2 }, 
            { 10, 11} 
        };      
    }
    
    @Test
    @Parameters({ "example-subtract", "example-subtract-result" })
    public void testSubtract(int i, int result) {
        this.calculator.subtract(i);
        assertEquals(result, this.calculator.getValue());
    }
    
    @SuppressWarnings("null")
    @Test(expectedExceptions = NullPointerException.class)
    public void testWithNull() {
        Integer i = null;
        this.calculator.add(i);
    }
}
