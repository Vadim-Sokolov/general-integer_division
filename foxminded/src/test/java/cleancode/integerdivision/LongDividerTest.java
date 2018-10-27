package cleancode.integerdivision;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class LongDividerTest {
	
	private LongDivider divider = new LongDivider();
	
	@Test(expected=ArithmeticException.class)
	public void shouldThrowException_whenDivisorIsZero() {
		divider.divideIntegerUsingLongDivision_andRecordTheProcess(344, 0);
	}

	@Test
	public void shouldWorkWithPositiveIntegers() {
		divider.divideIntegerUsingLongDivision_andRecordTheProcess(78945, 4);
		//assertEquals()
	}
}
