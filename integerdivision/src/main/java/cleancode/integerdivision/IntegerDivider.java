package cleancode.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivider {

	private List<DivisionStep> divisionSteps = new ArrayList<>();
	private int dividend;
	private int divisor;
	private int quotient;
	private int remainder;
	private int currentIndex;

	public void performIntegerDivision(int dividend, int divisor) {
		if (divisor == 0) {
			throw new ArithmeticException();
		}
		initializeInstanceVariables(dividend, divisor);
		int absoluteDividend = Math.abs(dividend);
		int absoluteDivisor = Math.abs(divisor);
		int[] digitsOfDividend = convertIntegerToDigits(absoluteDividend);
		divide(absoluteDivisor, digitsOfDividend);
	}

	private void initializeInstanceVariables(int dividend, int divisor) {
		setDividend(dividend);
		setDivisor(divisor);
		setQuotient(dividend / divisor);
		setRemainder(dividend % divisor);
	}

	private int[] convertIntegerToDigits(int input) {
		String integerToString = Integer.toString(input);
		int[] digits = new int[integerToString.length()];
		for (int i = 0; i < integerToString.length(); i++) {
			digits[i] = Character.getNumericValue(integerToString.charAt(i));
		}
		return digits;
	}

	private void divide(int divisor, int[] digitsOfDividend) {
		int currentDividendNumber = digitsOfDividend[0];
		int index = 1;
		while (index < digitsOfDividend.length) {
			if (currentDividendNumber < divisor) {
				currentDividendNumber = getNextDividend(currentDividendNumber, digitsOfDividend, index, divisor);
				index = currentIndex;
			} else {
				index++;
			}
			createStep(currentDividendNumber, divisor);
			currentDividendNumber = currentDividendNumber % divisor;
		}
	}

	private int getNextDividend(int currentDividendNumber, int[] digits, int index, int divisor) {
		while (currentDividendNumber < divisor) {
			if (index < digits.length) {
				currentDividendNumber = combineTwoIntegers(currentDividendNumber, digits[index++]);
			} else {
				break;
			}
		}
		setCurrentIndex(index);
		return currentDividendNumber;
	}

	private int combineTwoIntegers(int first, int second) {
		return Integer.parseInt(Integer.toString(first) + Integer.toString(second));
	}

	private void createStep(int currentDividendNumber, int divisor) {
		int currentQuotient = currentDividendNumber / divisor;
		int integerToSubtract = divisor * currentQuotient;
		divisionSteps.add(new DivisionStep(currentDividendNumber, integerToSubtract));
	}

	public List<DivisionStep> getDivisionSteps() {
		return divisionSteps;
	}

	public int getDividend() {
		return dividend;
	}

	private void setDividend(int dividend) {
		this.dividend = dividend;
	}

	public int getDivisor() {
		return divisor;
	}

	private void setDivisor(int divisor) {
		this.divisor = divisor;
	}

	public int getQuotient() {
		return quotient;
	}

	private void setQuotient(int quotient) {
		this.quotient = quotient;
	}

	public int getRemainder() {
		return remainder;
	}

	private void setRemainder(int remainder) {
		this.remainder = remainder;
	}

	private void setCurrentIndex(int index) {
		this.currentIndex = index;
	}

}
