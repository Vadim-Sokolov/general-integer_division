package cleancode.integerdivision;

public class Step {
	
	private int dividend;
	private int integerToSubtract;
	
	public Step(int dividend, int integerToSubtract) {
		this.dividend = dividend;
		this.integerToSubtract = integerToSubtract;
	}

	public int getDividend() {
		return dividend;
	}

	public int getIntegerToSubtract() {
		return integerToSubtract;
	}
}
