package cleancode.anagrams;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class WordsReverser {
	
	public String reverseWords(String wordsToReverse) {
		StringBuilder result = new StringBuilder();
		String[] words = splitStringIntoWords(wordsToReverse);
		for (String word : words) {
			result.append(createReversedWord(word) + " ");
		}
		return result.toString().trim();
	}
	
	public String[] splitStringIntoWords(String stringToSplit) {
		return stringToSplit.split("\\s+");
	}
	
	public String createReversedWord(String word) {
		StringBuilder result = getReversedWordWithoutNonLetters(word);
		Map<Integer, Character> nonLettersPositions = getNonLettersPositions(word);
		setNonLettersToReversedWord(result, nonLettersPositions);
		return result.toString();
	}
	
	public StringBuilder getReversedWordWithoutNonLetters(String word) {
		StringBuilder wordWithoutNonLetters = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			if (Character.isLetter(word.charAt(i))) {
				wordWithoutNonLetters.append(word.charAt(i));
			}
		}
		return wordWithoutNonLetters.reverse();
	}
	
	public Map<Integer, Character> getNonLettersPositions(String word) {
		Map<Integer, Character> nonLetters = new TreeMap<>();
		for (int i = 0; i < word.length(); i++) {
			if (!Character.isLetter(word.charAt(i))) {
				nonLetters.put(i, word.charAt(i));
			}
		}
		return nonLetters;
	}
	
	public void setNonLettersToReversedWord(StringBuilder result, Map<Integer, Character> nonLetters) {
		for(Map.Entry<Integer, Character> nonLetter : nonLetters.entrySet()) {
			result.insert(nonLetter.getKey(), String.valueOf(nonLetter.getValue()));
		}
	}
}
