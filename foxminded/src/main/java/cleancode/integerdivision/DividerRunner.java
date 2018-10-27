package cleancode.integerdivision;

import java.util.List;

public class DividerRunner {
	
	public static void main(String[] args) {
		LongDivider divider = new LongDivider();
		divider.divideIntegerUsingLongDivision_andRecordTheProcess(78945, 4);
		ResultBuilder resultBuilder = new ResultBuilder();
		System.out.println(resultBuilder.convertDivisionResultIntoString(divider));
	}
}
