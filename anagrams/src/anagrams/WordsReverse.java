package anagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class WordsReverse {
	
	public String wordsReverse(String string) {
		StringBuilder stringBuilder = new StringBuilder();
		String[] target = stringSplit(string);
		for (String s : target) {
			stringBuilder.append(charsRearrange(s) + " ");
		}
		return stringBuilder.toString();
	}
	
	public String[] stringSplit(String string) {
		return string.split("\\s+");
	}
	
	public String charsRearrange(String string) {
		char[] stringToChars = string.toCharArray(); 
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
	
	public static void main(String[] args) {
		WordsReverse w = new WordsReverse();
		String test = "St4dium ex!t 5trategy.";
		System.out.println(w.wordsReverse(test));
	}
}
