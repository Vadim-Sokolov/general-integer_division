package cleancode.anagrams;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Map;
import java.util.TreeMap;

public class WordsReverserTest {
	
	WordsReverser wordsReverser = new WordsReverser();
	
	@Test
	public void testSetNonLettersToReversedWord() {
		StringBuilder testStringBuilder = new StringBuilder("Lnk");
		Map<Integer, Character> testTreeMap = new TreeMap<Integer, Character>() {{ put(1, '!'); put(3, '9');}};
		String expected = "L!n9k";
		wordsReverser.setNonLettersToReversedWord(testStringBuilder, testTreeMap);
		String actual = testStringBuilder.toString();
		assertThat(actual, is(expected));
	}
	
	@Test
	public void testGetNonLettersPositions() {
		String testString = "L!n9k";
		Map<Integer, Character> expected = new TreeMap<Integer, Character>() {{ put(1, '!'); put(3, '9');}};
		Map<Integer, Character> actual = wordsReverser.getNonLettersPositions(testString);
		assertThat(actual, is(expected));
	}
	
	@Test
	public void testGetReversedWordWithoutNonLetters() {
		String testString = "L2i4n6k";
		String expected = "kniL";
		String actual = wordsReverser.getReversedWordWithoutNonLetters(testString).toString();
		assertThat(actual, is(expected));
	}
	
	@Test
	public void testSplitStringIntoWords() {
		String testString = "abc abc";
		String[] expected = new String[] {"abc", "abc"};
		assertThat(wordsReverser.splitStringIntoWords(testString), is(expected));
	}

	@Test
	public void testReverseWords() {
		String testString = "123abc456";
		String expected = "123cba456";
		assertThat(wordsReverser.reverseWords(testString), is(expected));
	}

}
