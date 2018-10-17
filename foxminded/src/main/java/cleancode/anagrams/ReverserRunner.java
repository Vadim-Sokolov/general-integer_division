package cleancode.anagrams;

public class ReverserRunner {
	
	public static void main(String[] args) {
		WordsReverser wordsReverser = new WordsReverser();
		String test = "123abc456";
		System.out.println(wordsReverser.reverseWords(test));
	}

}
