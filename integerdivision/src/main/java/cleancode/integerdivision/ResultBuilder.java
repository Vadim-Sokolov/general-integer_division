package cleancode.integerdivision;

import java.util.Arrays;
import java.util.List;

public class ResultBuilder {

	private StringBuilder result = new StringBuilder();

	public String convertDivisionResultToString(IntegerDivider divider) {
		int dividendLength = getIntegerLength(Math.abs(divider.getDividend()));
		appendFirstLine(divider, dividendLength);
		appendSecondLine(divider, dividendLength);
		appendThirdLine(divider, dividendLength);
		appendDivisionSteps(divider.getSteps());
		appendLastLine(divider, dividendLength);
		return this.result.toString();
	}

	private void appendFirstLine(IntegerDivider divider, int dividendLength) {
		if (divider.getDividend() >= 0) {
			result.append("_");
		}
		if (dividendLength < getIntegerLength(divider.getDivisor())) {
			result.append(divider.getDividend() + createStringOfChars(getIntegerLength(divider.getDivisor()) - 2, ' ')
					+ "|" + divider.getDivisor() + "\n");
		} else {
			result.append(divider.getDividend() + "|" + divider.getDivisor() + "\n");
		}
	}

	private void appendSecondLine(IntegerDivider divider, int dividendLength) {
		if (divider.getDivisor() > 0) {
			result.append(" ");
		}
		result.append(divider.getDivisor()
				+ createStringOfChars(dividendLength - getIntegerLength(Math.abs(divider.getDivisor())), ' ') + "|"
				+ createStringOfChars(getIntegerLength(divider.getQuotient()), '-') + "\n");
	}

	private void appendThirdLine(IntegerDivider divider, int dividendLength) {
		result.append(" " + createStringOfChars(getIntegerLength(Math.abs(divider.getDivisor())), '-')
				+ createStringOfChars(dividendLength - getIntegerLength(Math.abs(divider.getDivisor())), ' ') + "|"
				+ divider.getQuotient() + "\n");
	}

	private void appendDivisionSteps(List<Step> steps) {
		for (int i = 1; i < steps.size(); i++) {
			String dividendSpaces = "";
			String spaces = "";
			if (i == 1) {
				dividendSpaces = createStringOfChars(i - 1, ' ');
				spaces = createStringOfChars(i, ' ');
			} else {
				dividendSpaces = createStringOfChars(i - 3 + getIntegerLength(steps.get(i - 1).getDividend()), ' ');
				spaces = createStringOfChars(i - 2 + getIntegerLength(steps.get(i - 1).getIntegerToSubtract()), ' ');
			}
			result.append(dividendSpaces + "_" + steps.get(i).getDividend() + "\n" + spaces
					+ steps.get(i).getIntegerToSubtract() + "\n" + spaces
					+ createStringOfChars(getIntegerLength(steps.get(i).getIntegerToSubtract()), '-') + "\n");
		}
	}

	private void appendLastLine(IntegerDivider divider, int dividendLength) {
		if (dividendLength < getIntegerLength(divider.getDivisor())) {
			result.append(
					createStringOfChars(getIntegerLength(divider.getDivisor()) - 1, ' ') + divider.getRemainder());
		} else {
			result.append(createStringOfChars(dividendLength - 1, ' ') + divider.getRemainder());
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
