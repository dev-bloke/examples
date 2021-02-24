package com.meridal.examples;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Java Lambda Example methods.
 */
public class LambdaExamples {
	
	private static final Pattern WORD_SPLITTER = Pattern.compile(" ");
	private static final String ELLIPSIS = "...";
	
	/**
	 * Get a TL;DR version of a string by extracting the first few words.
	 * @param input The string to summarize
	 * @param words Maximum number of words to extract
	 * @return TL;DR version of the string
	 */
	public String getStringSummary(final String input, int words) {
		if (this.countWords(input) <= words) return input;
		return WORD_SPLITTER.splitAsStream(input)
			.limit(words)
			.collect(Collectors.joining(" "))
			+ ELLIPSIS;
	}
	
	/**
	 * Count the number of words in a string.
	 * @param input Input
	 * @return Number of words
	 */
	public int countWords(final String input) {
		if (input == null || input.length() == 0) return 0;
		return (int) WORD_SPLITTER.splitAsStream(input).count();
	}
}
