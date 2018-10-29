package cleancode.integerdivision;

public class Step {
	private int dividend;
	private int product;
	
	public Step(int dividend, int product) {
		this.dividend = dividend;
		this.product = product;
	}

	public int getDividend() {
		return dividend;
	}

	public int getProduct() {
		return product;
	}
}
