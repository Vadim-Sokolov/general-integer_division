package cleancode.anagrams;

import static org.junit.Assert.*;
import org.junit.Test;
import cleancode.anagrams.WordsReverser;
import static org.hamcrest.CoreMatchers.*;

public class WordsReverserTest {
	
	private WordsReverser wordsReverser = new WordsReverser();
	
	@Test
	public void shouldNotReverseText_whenTheTextContainsOnlyNumbers() {
		String testString = "123456";
		String expected = "123456";
		assertEquals(expected, wordsReverser.reverseWords(testString));
	}
	
	@Test
	public void shouldTrimAllSpaces_whenTheWordConsistsOnlyOfSpaces() {
		String testString = "   ";
		String expected = "";
		assertEquals(expected, wordsReverser.reverseWords(testString));
	}
	
	@Test
	public void shouldReverseWordCompletely_whenTheWordContainsOnlyLetters() {
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
	public void shouldReverseLettersOnly_whenTheWordContainsBothLettersAndNonLettersCharacters() {
		String testString = "123a?\"!bc 456";
		String expected = "123c?\"!ba 456";
		assertEquals(expected, wordsReverser.reverseWords(testString));
	}

}
