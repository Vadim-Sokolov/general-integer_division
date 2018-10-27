package cleancode.integerdivision;

public class Pair {
	private int dividend;
	private int product;
	
	public Pair(int dividend, int product) {
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
