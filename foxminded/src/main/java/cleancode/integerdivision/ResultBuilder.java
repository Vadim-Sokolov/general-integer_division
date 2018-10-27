package cleancode.integerdivision;

import java.util.Arrays;
import java.util.List;

public class ResultBuilder {
	
	private StringBuilder result = new StringBuilder();

	public String convertDivisionResultIntoString(LongDivider divider) {
		int dividend = divider.getDividend();
		int divisor = divider.getDivisor();
		int quotient = divider.getQuotient();
		int dividendLength = getIntegerLength(dividend);
		List<Pair> pairs = divider.getPairs();
		String emptySpace = createStringOfSpaces(dividendLength - 1);
		
		result.append("_" + dividend + "|" + divisor + "\n");
		result.append("_" + divisor + emptySpace + "|" + "-----" + "\n");
		result.append(" -" + emptySpace + "|" + quotient + "\n");
		for (int i = 1; i < pairs.size(); i++) {
			String spaces = createStringOfSpaces(i);
			result.append(spaces + pairs.get(i).getDividend() + "\n" 
					+ spaces + pairs.get(i).getProduct() + "\n" 
					+ spaces + "--" + "\n");
		}
		result.append(createStringOfSpaces(dividendLength) + divider.getRemainder());
		return this.result.toString();
	}
	
	private int getIntegerLength(int input) {
		return Integer.toString(input).length();
	}
	
	private String createStringOfSpaces(int length) {
		String result = "";
		  if (length > 0) {
		    char[] array = new char[length];
		    Arrays.fill(array, ' ');
		    result = new String(array);
		  }
		  return result;
		}
}
