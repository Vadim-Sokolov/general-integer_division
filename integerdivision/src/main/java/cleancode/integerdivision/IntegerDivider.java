package cleancode.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivider {
	
	private List<Step> steps = new ArrayList<>();
	private int dividend;
	private int divisor;
	private int quotient;
	private int remainder;

	public void divideInteger(int dividend, int divisor) {
		if (divisor == 0) {
			throw new ArithmeticException();
		}
		initializeInstanceVariables(dividend, divisor);
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int[] digitsOfDividend = convertIntegerToDigits(dividend);
		doLongDivision(dividend, divisor, digitsOfDividend);
	}
	
	private void doLongDivision(int dividend, int divisor, int[] digitsOfDividend) {
		int currentNumber = digitsOfDividend[0];
		int index = 0;
		while (index < digitsOfDividend.length) {
			if (currentNumber < divisor) {
				DividendAndIndex nextDividendAndIndex = getNextDividendAndIndex(currentNumber, digitsOfDividend, index, divisor);
				currentNumber = nextDividendAndIndex.getDividend();
				index = nextDividendAndIndex.getIndex();
			} else {
				index++;
			}
			createAndAddStep(currentNumber, divisor);
			currentNumber = currentNumber % divisor;
		}
	}
	
	private void createAndAddStep(int currentNumber, int divisor) {
		int currentQuotient = currentNumber / divisor;
		int integerToSubtract = divisor * currentQuotient;
		Step step = new Step(currentNumber, integerToSubtract);
		steps.add(step);
	}
	
	private DividendAndIndex getNextDividendAndIndex(int currentNumber, int[] digits, int index, int divisor) {
		while (currentNumber < divisor) {
			if (index < digits.length) {
				currentNumber = combineTwoIntegers(currentNumber, digits[index++]);
			} else {
				break;
			}
		}
		return new DividendAndIndex(currentNumber, index);
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
	
	private int combineTwoIntegers(int first, int second) {
		return Integer.parseInt(Integer.toString(first) + Integer.toString(second));
	}

	public List<Step> getSteps() {
		return steps;
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
	
}
