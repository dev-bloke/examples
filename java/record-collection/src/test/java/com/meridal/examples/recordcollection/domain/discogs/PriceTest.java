package com.meridal.examples.recordcollection.domain.discogs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriceTest {

	@Test
	public void testToStringWithValue() {
		final Price price = new Price("GBP", "123.45");
		assertEquals("£123.45", price.toString());
	}

	@Test
	public void testToStringWithNoValue() {
		final Price price = new Price("GBP", null);
		assertEquals("£-", price.toString());
	}

	@Test
	public void testToStringWithNoCurrency() {
		final Price price = new Price(null, "123.45");
		assertEquals("-", price.toString());
	}

	@Test
	public void testToStringWithInvalidCurrency() {
		final Price price = new Price("WIBBLE", "123.45");
		assertEquals("-", price.toString());
	}

	@Test
	public void testToStringWithInvalidValue() {
		final Price price = new Price("GBP", "xyz");
		assertEquals("£-", price.toString());
	}
}
