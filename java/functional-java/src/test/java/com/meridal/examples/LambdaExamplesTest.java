package com.meridal.examples;

import static org.junit.Assert.*;

import org.junit.Test;

public class LambdaExamplesTest {
	
	private static final String SHORT_SENTENCE = "Wind in the lonely fences";
	private static final String LONG_SENTENCE = SHORT_SENTENCE + " rattles and whistles";
	private static final String EMPTY = "";
	private static final String ELLIPSIS = "...";

	
	private LambdaExamples examples = new LambdaExamples();
	
	@Test
	public void testCountWordsWithSentence() {
		assertEquals(5, this.examples.countWords(SHORT_SENTENCE));
	}
	
	@Test
	public void testCountWordsWithEmptyString() {
		assertEquals(0, this.examples.countWords(EMPTY));
	}
	
	@Test
	public void testCountWordsWithNull() {
		assertEquals(0, this.examples.countWords(null));
	}
	
	@Test
	public void testGetStringSummaryWithShortSentence() {
		assertEquals(SHORT_SENTENCE, this.examples.getStringSummary(SHORT_SENTENCE, 5));
	}

	@Test
	public void testGetStringSummaryWithLongSentence() {
		assertEquals(SHORT_SENTENCE + ELLIPSIS, this.examples.getStringSummary(LONG_SENTENCE, 5));
	}

	@Test
	public void testGetStringSummaryWithEmptyString() {
		assertEquals(EMPTY, this.examples.getStringSummary(EMPTY, 5));
	}
	
	@Test
	public void testGetStringSummaryWithNull() {
		assertEquals(null, this.examples.getStringSummary(null, 5));
	}
}
