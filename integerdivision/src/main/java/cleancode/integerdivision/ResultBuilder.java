package cleancode.integerdivision;

import java.util.Arrays;
import java.util.List;

public class ResultBuilder {
	
	private StringBuilder result = new StringBuilder();

	public String convertDivisionResultToString(IntegerDivider divider) {
		int dividend = divider.getDividend();
		int divisor = divider.getDivisor();
		int quotient = divider.getQuotient();
		int dividendLength = getIntegerLength(Math.abs(dividend));
		List<Step> steps = divider.getSteps();
		String emptySpaceAftetDivisor = createStringOfChars(dividendLength - getIntegerLength(Math.abs(divisor)), ' ');
		String emptySpaceBeforeQuotient = createStringOfChars(dividendLength - getIntegerLength(Math.abs(divisor)), ' ');
		String lineBetweenDivisorAndQuotient = createStringOfChars(getIntegerLength(quotient), '-');
		
		if (dividend >= 0) {
			result.append("_");
		}
		if (dividendLength < getIntegerLength(divisor)) {
			result.append(dividend + createStringOfChars(getIntegerLength(divisor) - 2, ' ') + "|" + divisor + "\n");
		} else {
			result.append(dividend + "|" + divisor + "\n");
		}
		if (divisor > 0) {
			result.append(" ");
		}
		result.append(divisor + emptySpaceAftetDivisor + "|" + lineBetweenDivisorAndQuotient + "\n");
		result.append(" "+ createStringOfChars(getIntegerLength(Math.abs(divisor)), '-') + emptySpaceBeforeQuotient + "|" + quotient + "\n");
		appendDivisionSteps(result, steps);
		if (dividendLength < getIntegerLength(divisor)) {
			result.append(createStringOfChars(getIntegerLength(divisor) - 1, ' ') + divider.getRemainder());
		} else {
			result.append(createStringOfChars(dividendLength - 1, ' ') + divider.getRemainder());
		}
		return this.result.toString();
	}
	
	private void appendDivisionSteps(StringBuilder stringBuilder, List<Step> steps) {
		for (int i = 1; i < steps.size(); i++) {
			String dividendSpaces = "";
			String spaces = "";
			if (i == 1) {
				dividendSpaces = createStringOfChars(i - 1, ' ');
				spaces = createStringOfChars(i, ' ');
			} else {
				dividendSpaces = createStringOfChars(i - 3 + getIntegerLength(steps.get(i - 1).getDividend()), ' ');
				spaces = createStringOfChars(i - 2 + getIntegerLength(steps.get(i - 1).getProduct()), ' ');
			}
			result.append(dividendSpaces + "_" + steps.get(i).getDividend() 
					+ "\n" + spaces + steps.get(i).getProduct()
					+ "\n" + spaces + createStringOfChars(getIntegerLength(steps.get(i).getProduct()), '-') + "\n");
		}
	}
	
	private int getIntegerLength(int input) {
		return Integer.toString(input).length();
	}

	private String createStringOfChars(int length, char input) {
		String result = "";
		if (length > 0) {
			char[] array = new char[length];
			Arrays.fill(array, input);
			result = new String(array);
		}
		return result;
	}
}
