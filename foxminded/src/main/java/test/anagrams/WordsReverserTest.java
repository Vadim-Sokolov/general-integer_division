package test.anagrams;

import static org.junit.Assert.*;
import org.junit.Test;

import cleancode.anagrams.WordsReverser;
import static org.hamcrest.CoreMatchers.*;

import java.util.Map;
import java.util.TreeMap;

public class WordsReverserTest {
	
	private WordsReverser wordsReverser = new WordsReverser();
	
	@Test
	public void testOnlyNumbers() {
		String testString = "123456";
		String expected = "123456";
		assertEquals(expected, wordsReverser.reverseWords(testString));
	}
	
	@Test
	public void testOnlySpaces() {
		String testString = "   ";
		String expected = "";
		assertEquals(expected, wordsReverser.reverseWords(testString));
	}
	
	@Test
	public void testOnlyLetters() {
		String testString = "abcdefGhiJkLM";
		String expected = "MLkJihGfedcba";
		assertEquals(expected, wordsReverser.reverseWords(testString));
	}
	
	@Test(expected=NullPointerException.class)
	public void testNullInput() {
		String testString = null;
		fail(wordsReverser.reverseWords(testString));
	}
	
	@Test
	public void testLettersAndNonLetters() {
		String testString = "123abc 456";
		String expected = "123cba 456";
		assertEquals(expected, wordsReverser.reverseWords(testString));
	}

}
