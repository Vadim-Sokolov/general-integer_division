package cleancode.anagrams;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class WordsReverser {
	
	public String reverseWords(String wordsToReverse) {
		StringBuilder result = new StringBuilder();
		String[] splitWordsBySpaces = splitStringIntoWords(wordsToReverse);
		for (String word : splitWordsBySpaces) {
			result.append(createReversedWord(word) + " ");
		}
		return result.toString().trim();
	}
	
	private String[] splitStringIntoWords(String stringToSplit) {
		return stringToSplit.split("\\s+");
	}
	
	private String createReversedWord(String word) {
		StringBuilder result = getReversedWordWithoutNonLetters(word);
		SortedMap<Integer, Character> nonLettersPositions = getNonLettersPositions(word);
		setNonLettersToReversedWord(result, nonLettersPositions);
		return result.toString();
	}
	
	private StringBuilder getReversedWordWithoutNonLetters(String word) {
		StringBuilder wordWithoutNonLetters = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			if (Character.isLetter(word.charAt(i))) {
				wordWithoutNonLetters.append(word.charAt(i));
			}
		}
		return wordWithoutNonLetters.reverse();
	}
	
	private SortedMap<Integer, Character> getNonLettersPositions(String word) {
		SortedMap<Integer, Character> nonLetters = new TreeMap<>();
		for (int i = 0; i < word.length(); i++) {
			if (!Character.isLetter(word.charAt(i))) {
				nonLetters.put(i, word.charAt(i));
			}
		}
		return nonLetters;
	}
	
	private void setNonLettersToReversedWord(StringBuilder result, SortedMap<Integer, Character> nonLetters) {
		for (int i = 0; i < (result.length() + nonLetters.size()); i++) {
			if (nonLetters.containsKey(i)) {
				result.insert(i, nonLetters.get(i));
			}
		}
	}
}
