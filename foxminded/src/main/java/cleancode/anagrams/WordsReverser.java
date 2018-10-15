package cleancode.anagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
		char[] stringToChars = input.toCharArray(); 
		ArrayList<Character> letters = new ArrayList<>();
		HashMap<Integer, Character> nonLetters = new HashMap<>();
		for (int i = 0; i < stringToChars.length; i++) {
			if (Character.isLetter(stringToChars[i])) {
				letters.add(stringToChars[i]);
			} else {
				nonLetters.put(i, stringToChars[i]);
			}
		}
		Collections.reverse(letters);
		int index = 0;
		char[] result = new char[stringToChars.length];
		for (int i = 0; i < stringToChars.length; i++) {
			if (nonLetters.containsKey(i)) {
				result[i] = nonLetters.get(i);
			} else {
				result[i] = letters.get(index++);
			}
		}
		return new String(result);
	}
}
