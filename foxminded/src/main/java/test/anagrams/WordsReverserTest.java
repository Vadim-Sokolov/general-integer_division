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
	public void shouldNotReverseText_whenContainsOnlyNumbers() {
		String testString = "123456";
		String expected = "123456";
		assertEquals(expected, wordsReverser.reverseWords(testString));
	}
	
	@Test
	public void shouldTrimAllSpaces_whenContainsOnlySpaces() {
		String testString = "   ";
		String expected = "";
		assertEquals(expected, wordsReverser.reverseWords(testString));
	}
	
	@Test
	public void shouldReverseWordCompletely_whenContainsOnlyLetters() {
		String testString = "abcdefGhiJkLM";
		String expected = "MLkJihGfedcba";
		assertEquals(expected, wordsReverser.reverseWords(testString));
	}
	
	@Test(expected=NullPointerException.class)
	public void shouldThrowException_whenInputIsNull() {
		String testString = null;
		fail(wordsReverser.reverseWords(testString));
	}
	
	@Test
	public void testLettersAndNonLetters() {
		String testString = "123a?\"!bc 456";
		String expected = "123c?\"!ba 456";
		assertEquals(expected, wordsReverser.reverseWords(testString));
	}

}
