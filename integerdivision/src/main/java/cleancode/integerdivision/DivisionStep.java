package cleancode.integerdivision;

public class DivisionStep {

	private int dividend;
	private int integerToSubtract;

	public DivisionStep(int dividend, int integerToSubtract) {
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
