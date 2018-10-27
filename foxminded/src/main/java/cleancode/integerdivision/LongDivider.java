package cleancode.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class LongDivider {
	
	private List<Pair> pairs = new ArrayList<>();
	private int dividend;
	private int divisor;
	private int quotient;
	private int remainder;

	public void divideIntegerUsingLongDivision_andRecordTheProcess(int dividend, int divisor) throws ArithmeticException {
		
		if (divisor == 0) {
			throw new ArithmeticException();
		}
		
		setDividend(dividend);
		setDivisor(divisor);
		setQuotient(dividend / divisor);
		setRemainder(dividend % divisor);
		
		int[] digitsOfDividend = convertIntegerToArrayOfDigits(dividend);
		int currentQuotient = 0;
		int product = 0;
		int currentNumber = digitsOfDividend[0];
		
		for (int i = 0; i < digitsOfDividend.length; i++) {
			if (currentNumber < divisor) {
				currentNumber = combineTwoIntegersIntoNewInteger(currentNumber, digitsOfDividend[i]);
			} 
			currentQuotient = currentNumber / divisor;
			product = divisor * currentQuotient;
			Pair newPair = new Pair(currentNumber, product);
			pairs.add(newPair);
			currentNumber = currentNumber % divisor;
		}
	}
	
	private int[] convertIntegerToArrayOfDigits(int input) {
		String inputToString = Integer.toString(input);
		int[] digitsOfInput = new int[inputToString.length()];
		for (int i = 0; i < inputToString.length(); i++) {
			digitsOfInput[i] = Character.getNumericValue(inputToString.charAt(i));
		}
		return digitsOfInput;
	}
	
	private int combineTwoIntegersIntoNewInteger(int first, int second) {
		String intsCombined = Integer.toString(first) + Integer.toString(second);
		return Integer.parseInt(intsCombined);
	}

	public List<Pair> getPairs() {
		return pairs;
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
