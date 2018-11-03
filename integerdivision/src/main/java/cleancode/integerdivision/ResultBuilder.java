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
		appendDivisionSteps(divider.getDivisionSteps());
		appendLastLine(divider, dividendLength);
		return result.toString();
	}

	private int getIntegerLength(int input) {
		return Integer.toString(input).length();
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

	private String createStringOfChars(int length, char input) {
		String result = "";
		if (length > 0) {
			char[] array = new char[length];
			Arrays.fill(array, input);
			result = new String(array);
		}
		return result;
	}

	private void appendSecondLine(IntegerDivider divider, int dividendLength) {
		if (divider.getDivisor() > 0) {
			result.append(" ");
		}
		result.append(divider.getDivisor()
				+ createStringOfChars(dividendLength - getIntegerLength(Math.abs(divider.getDivisor())), ' ') + "|");
		if (getIntegerLength(divider.getDivisor()) > getIntegerLength(divider.getQuotient())) {
			result.append(createStringOfChars(getIntegerLength(divider.getDivisor()), '-') + "\n");
		} else {
			result.append(createStringOfChars(getIntegerLength(divider.getQuotient()), '-') + "\n");
		}
	}

	private void appendThirdLine(IntegerDivider divider, int dividendLength) {
		result.append(" " + createStringOfChars(getIntegerLength(Math.abs(divider.getDivisor())), '-')
				+ createStringOfChars(dividendLength - getIntegerLength(Math.abs(divider.getDivisor())), ' ') + "|"
				+ divider.getQuotient() + "\n");
	}

	private void appendDivisionSteps(List<DivisionStep> divisionSteps) {
		for (int i = 1; i < divisionSteps.size(); i++) {
			String dividendSpaces = createDividendSpaces(i, divisionSteps);
			String integerToSubtractspaces = createIntegerToSubtractSpaces(i, divisionSteps);
			result.append(dividendSpaces + "_" + divisionSteps.get(i).getDividend() + "\n" + integerToSubtractspaces
					+ divisionSteps.get(i).getIntegerToSubtract() + "\n" + integerToSubtractspaces
					+ createStringOfChars(getIntegerLength(divisionSteps.get(i).getIntegerToSubtract()), '-') + "\n");
		}
	}

	private String createDividendSpaces(int index, List<DivisionStep> divisionSteps) {
		String result = "";
		if (index == 1) {
			result = createStringOfChars(index - 1, ' ');
		} else {
			result = createStringOfChars(index - 3 + getIntegerLength(divisionSteps.get(index - 1).getDividend()), ' ');
		}
		return result;
	}

	private String createIntegerToSubtractSpaces(int index, List<DivisionStep> divisionSteps) {
		String result = "";
		if (index == 1) {
			result = createStringOfChars(index, ' ');
		} else {
			result = createStringOfChars(
					index - 2 + getIntegerLength(divisionSteps.get(index - 1).getIntegerToSubtract()), ' ');
		}
		return result;
	}

	private void appendLastLine(IntegerDivider divider, int dividendLength) {
		if (dividendLength < getIntegerLength(divider.getDivisor())) {
			result.append(
					createStringOfChars(getIntegerLength(divider.getDivisor()) - 1, ' ') + divider.getRemainder());
		} else {
			result.append(createStringOfChars(dividendLength, ' ') + divider.getRemainder());
		}
	}
}
