package com.meridal.examples;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A simple tallying component.
 * @author Martin Ingram
 */
public class Tally {
    
    private Map<String, Integer> tallies;
    
    public Tally() {
        this.tallies = new LinkedHashMap<>();
    }
    
    /**
     * Add the specified amount to the tally for the given category.
     * @param category Category
     * @param amount Amount
     */
    public void add(String category, Integer amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null.");
        }
        int value = this.tallies.getOrDefault(category, 0);
        value += amount;
        this.tallies.put(category, value);
    }
    
    /**
     * Subtract the specified amount from the tally for the given category.
     * @param category Category
     * @param amount Amount
     */
    public void subtract(String category, Integer amount) {
        this.add(category, 0 - amount);
    }
    
    /**
     * Get the total tally for the specified category.
     * @param category Category
     * @return Total tally
     */
    public Integer getTotal(String category) {
        return this.tallies.getOrDefault(category, 0);
    }

    /**
     * Get all totals held.
     * @return Map of tallies
     */
    public Map<String, Integer> getAllTotals() {
        return this.tallies;
    }
}
