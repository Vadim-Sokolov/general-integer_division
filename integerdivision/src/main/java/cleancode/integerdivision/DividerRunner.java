package cleancode.integerdivision;

public class DividerRunner {
	
	public static void main(String[] args) {
		IntegerDivider divider = new IntegerDivider();
		divider.divideInteger(78945, 4);
		ResultBuilder resultBuilder = new ResultBuilder();
		System.out.println(resultBuilder.convertDivisionResultToString(divider));
	}
}
