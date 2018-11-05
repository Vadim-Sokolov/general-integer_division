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
			result.append(divider.getDividend())
					.append(createStringOfChars(getIntegerLength(divider.getDivisor()) - dividendLength, ' '))
					.append("|").append(divider.getDivisor()).append("\n");
		} else {
			result.append(divider.getDividend()).append("|").append(divider.getDivisor()).append("\n");
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
		result.append(divider.getDivisor())
				.append(createStringOfChars(dividendLength - getIntegerLength(Math.abs(divider.getDivisor())), ' '))
				.append("|");
		if (getIntegerLength(divider.getDivisor()) > getIntegerLength(divider.getQuotient())) {
			result.append(createStringOfChars(getIntegerLength(divider.getDivisor()), '-')).append("\n");
		} else {
			result.append(createStringOfChars(getIntegerLength(divider.getQuotient()), '-')).append("\n");
		}
	}

	private void appendThirdLine(IntegerDivider divider, int dividendLength) {
		result.append(" ").append(createStringOfChars(getIntegerLength(Math.abs(divider.getDivisor())), '-'))
				.append(createStringOfChars(dividendLength - getIntegerLength(Math.abs(divider.getDivisor())), ' '))
				.append("|").append(divider.getQuotient()).append("\n");
	}

	private void appendDivisionSteps(List<DivisionStep> divisionSteps) {
		for (int i = 1; i < divisionSteps.size(); i++) {
			String dividendSpaces = createDividendSpaces(i, divisionSteps);
			String integerToSubtractSpaces = createSubtractionSpaces(i, divisionSteps);
			appendLineToResult(result, dividendSpaces, integerToSubtractSpaces, divisionSteps, i);
		}
	}

	private String createDividendSpaces(int index, List<DivisionStep> divisionSteps) {
		String result;
		if (index == 1) {
			result = createStringOfChars(index - 1, ' ');
		} else {
			result = createStringOfChars(index - 1, ' ');
		}
		return result;
	}

	private String createSubtractionSpaces(int index, List<DivisionStep> divisionSteps) {
		String result;
		if (index == 1) {
			result = createStringOfChars(index, ' ');
		} else {
			result = createStringOfChars(index, ' ');
		}
		return result;
	}
	
	private void appendLineToResult(StringBuilder result, String dividendSpaces, String integerToSubtractSpaces,
			List<DivisionStep> divisionSteps, int index) {
		result.append(dividendSpaces).append("_").append(divisionSteps.get(index).getDividend()).append("\n")
				.append(integerToSubtractSpaces).append(divisionSteps.get(index).getIntegerToSubtract()).append("\n")
				.append(integerToSubtractSpaces)
				.append(createStringOfChars(getIntegerLength(divisionSteps.get(index).getIntegerToSubtract()), '-'))
				.append("\n");
	}

	private void appendLastLine(IntegerDivider divider, int dividendLength) {
		if (dividendLength < getIntegerLength(divider.getDivisor())) {
			result.append(createStringOfChars(getIntegerLength(divider.getDivisor()) - dividendLength, ' '))
					.append(divider.getRemainder());
		} else {
			result.append(createStringOfChars(dividendLength - getIntegerLength(divider.getDivisor()), ' ')).append(divider.getRemainder());
		}
	}
}
