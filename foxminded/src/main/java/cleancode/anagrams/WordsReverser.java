package cleancode.anagrams;

import java.util.Collections;
import java.util.TreeMap;

public class WordsReverser {
	
	public String reverseWords(String input) {
		StringBuilder stringBuilder = new StringBuilder();
		String[] inputSplitBySpaces = splitString(input);
		for (String word : inputSplitBySpaces) {
			stringBuilder.append(reverseLettersOnly(word) + " ");
		}
		return stringBuilder.toString().trim();
	}
	
	private String[] splitString(String input) {
		return input.split("\\s+");
	}
	
	private String reverseLettersOnly(String input) {
		StringBuilder result = getReversedWordWithoutNonLetters(input);
		TreeMap<Integer, Character> nonLettersPositions = getNonLettersPositions(input);
		setNonLettersToReversedWord(result, nonLettersPositions);
		return result.toString();
	}
	
	private StringBuilder getReversedWordWithoutNonLetters(String word) {
		StringBuilder letters = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			if (Character.isLetter(word.charAt(i))) {
				letters.append(word.charAt(i));
			}
		}
		return letters.reverse();
	}
	
	private TreeMap<Integer, Character> getNonLettersPositions(String word) {
		TreeMap<Integer, Character> nonLetters = new TreeMap<>();
		for (int i = 0; i < word.length(); i++) {
			if (!Character.isLetter(word.charAt(i))) {
				nonLetters.put(i, word.charAt(i));
			}
		}
		return nonLetters;
	}
	
	private void setNonLettersToReversedWord(StringBuilder result, TreeMap<Integer, Character> nonLetters) {
		for (int i = 0; i < result.length(); i++) {
			if (nonLetters.containsKey(i)) {
				result.insert(i, nonLetters.get(i));
			}
		}
	}
}
