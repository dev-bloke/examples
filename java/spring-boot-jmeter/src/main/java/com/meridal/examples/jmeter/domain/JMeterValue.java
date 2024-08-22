package com.meridal.examples.jmeter.domain;

import java.util.Random;

/**
 * A Simple value object used to test JMeter.
 */
public class JMeterValue {

    private static final Random RANDOM = new Random();

    private String first;
    private String second;
    private Integer third;
    private Double fourth;

    /**
     * Factory method that sets third and fourth to random values.
     * @param first First value
     * @param second Second value
     * @return A JMeter value object
     */
    public static JMeterValue create(final String first, final String second) {
        final JMeterValue value = new JMeterValue();
        value.setFirst(first);
        value.setSecond(second);
        value.setThird(RANDOM.nextInt());
        value.setFourth(RANDOM.nextDouble());
        return value;
    }

    public String getFirst() {
        return this.first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return this.second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public Integer getThird() {
        return this.third;
    }

    public void setThird(Integer third) {
        this.third = third;
    }

    public Double getFourth() {
        return this.fourth;
    }

    public void setFourth(Double fourth) {
        this.fourth = fourth;
    }
}
