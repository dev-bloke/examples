package com.meridal.examples.recordcollection.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchResultTest {

	@Test
	public void testToString() {
		final SearchResult result = new SearchResult(10, "A title");
		assertEquals("10 A title", result.toString());
	}

	@Test
	public void testToStringWithNoId() {
		final SearchResult result = new SearchResult(null, "Another title");
		assertEquals("null Another title", result.toString());
	}

	@Test
	public void testToStringWithNoTitle() {
		final SearchResult result = new SearchResult(10, null);
		assertEquals("10 null", result.toString());
	}
}
