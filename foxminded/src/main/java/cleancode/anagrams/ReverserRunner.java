package cleancode.anagrams;

public class ReverserRunner {
	
	public static void main(String[] args) {
		WordsReverser wordsReverser = new WordsReverser();
		String test = "St4dium ex!t 5trategy.";
		System.out.println(wordsReverser.reverseWords(test));
	}

}
