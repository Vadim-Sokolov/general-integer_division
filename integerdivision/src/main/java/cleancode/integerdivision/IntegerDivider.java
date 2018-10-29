package cleancode.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivider {
	
	private List<Step> steps = new ArrayList<>();
	private int dividend;
	private int divisor;
	private int quotient;
	private int remainder;

	public void divideInteger(int dividend, int divisor) throws ArithmeticException {
		if (divisor == 0) {
			throw new ArithmeticException();
		}
		setInstanceVariables(dividend, divisor);
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		
		int[] digitsOfDividend = convertIntegerToArrayOfDigits(dividend);
		int currentQuotient = 0;
		int product = 0;
		int currentNumber = digitsOfDividend[0];
		int index = 0;
		
		while (index < digitsOfDividend.length) {
			if (currentNumber < divisor) {
				int[] nextNumberAndNewIndex = getNextNumber(currentNumber, digitsOfDividend, index, divisor);
				currentNumber = nextNumberAndNewIndex[0];
				index = nextNumberAndNewIndex[1];
			} else {
				index++;
			}
			currentQuotient = currentNumber / divisor;
			product = divisor * currentQuotient;
			Step newStep = new Step(currentNumber, product);
			steps.add(newStep);
			currentNumber = currentNumber % divisor;
		}
	}
	
	private int[] getNextNumber(int currentNumber, int[] digits, int index, int divisor) {
		int[] result = { 0, 0 };
		while (currentNumber < divisor) {
			if (index < digits.length) {
				currentNumber = combineTwoIntegers(currentNumber, digits[index++]);
			} else {
				break;
			}
		}
		result[0] = currentNumber;
		result[1] = index;
		return result;
	}
	
	private void setInstanceVariables(int dividend, int divisor) {
		setDividend(dividend);
		setDivisor(divisor);
		setQuotient(dividend / divisor);
		setRemainder(dividend % divisor);
	}
	
	private int[] convertIntegerToArrayOfDigits(int input) {
		String inputToString = Integer.toString(input);
		int[] digitsOfInput = new int[inputToString.length()];
		for (int i = 0; i < inputToString.length(); i++) {
			digitsOfInput[i] = Character.getNumericValue(inputToString.charAt(i));
		}
		return digitsOfInput;
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
