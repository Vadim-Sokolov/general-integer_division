package cleancode.integerdivision;

public class DividerRunner {

	public static void main(String[] args) {
		IntegerDivider divider = new IntegerDivider();
		divider.performIntegerDivision(1, -1);
		ResultBuilder resultBuilder = new ResultBuilder();
		System.out.println(resultBuilder.convertDivisionResultToString(divider));
	}
}
