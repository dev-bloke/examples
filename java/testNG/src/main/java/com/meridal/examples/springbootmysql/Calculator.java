package com.meridal.examples.springbootmysql;

/**
 * A simple calculator.
 * @author Martin Ingram
 */
public class Calculator {
    
    private int value;
    
    public Calculator(int value) {
        this.value = value;
    }
    
    public void add(int value) {
        this.value += value;
    }
    
    public void divide(int value) {
        this.value = this.value / value;
    }
    
    public void multiply(int value) {
        this.value = this.value * value;
    }
    
    public void subtract(int value) {
        this.value = this.value - value;
    }
    
    public int getValue() {
        return this.value;
    }
}
