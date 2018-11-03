package cleancode.integerdivision;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class IntegerDividerTest {

	private IntegerDivider divider = new IntegerDivider();
	private ResultBuilder resultBuilder = new ResultBuilder();

	@Test(expected = ArithmeticException.class)
	public void shouldThrowException_whenDivideZeroByZero() {
		divider.performIntegerDivision(0, 0);
	}

	@Test(expected = ArithmeticException.class)
	public void shouldThrowException_whenDivideNegativeNumberByZero() {
		divider.performIntegerDivision(-10, 0);
	}

	@Test
	public void shouldReturnCorrectResult_whenDivideZeroByNegativeNumber() {
		divider.performIntegerDivision(0, -10);
		String expected = "_0 |-10\r\n" + "-10|---\r\n" + " --|0\r\n" + "  0";
		assertEquals(expected, resultBuilder.convertDivisionResultToString(divider));
	}

	@Test
	public void shouldReturnCorrectResult_whenDivideNegativeNumberByNegativeNumber() {
		divider.performIntegerDivision(-200200, -10);
		String expected = "-200200|-10\r\n" + "-10    |-----\r\n" + " --    |20020\r\n" + "_20\r\n" + " 20\r\n"
				+ " --\r\n" + " _20\r\n" + "  20\r\n" + "  --\r\n" + "  _0\r\n" + "   0\r\n" + "   -\r\n" + "      0";
		assertEquals(expected, resultBuilder.convertDivisionResultToString(divider));
	}

	@Test
	public void shouldReturnCorrectResult_whendivideNegativeNumberByPositiveNumber() {
		divider.performIntegerDivision(-200200, 1000);
		String expected = "-200200|1000\r\n" + " 1000  |----\r\n" + " ----  |-200\r\n" + "_2002\r\n" + " 2000\r\n"
				+ " ----\r\n" + "   _200\r\n" + "    0\r\n" + "    -\r\n" + "      -200";
		assertEquals(expected, resultBuilder.convertDivisionResultToString(divider));
	}

	@Test
	public void shouldReturnCorrectResult_whendividePositiveNumberByPositiveNumber() {
		divider.performIntegerDivision(78945, 4);
		String expected = "_78945|4[\r\n" + " 4    |-----\r\n" + " -    |19736\r\n" + "_38\r\n" + " 36\r\n" + " --\r\n"
				+ " _29\r\n" + "  28\r\n" + "  --\r\n" + "  _14\r\n" + "   12\r\n" + "   --\r\n" + "   _25\r\n"
				+ "    24\r\n" + "    --]\r\n" + "     1";
		assertEquals(expected, resultBuilder.convertDivisionResultToString(divider));
	}

	@Test
	public void shouldReturnCorrectResult_whendividePositiveNumberByOne() {
		divider.performIntegerDivision(10000000, 1);
		String expected = "_10000000|1\r\n" + " 1       |--------\r\n" + " -       |10000000\r\n" + "_0\r\n" + " 0\r\n"
				+ " -\r\n" + "        0";
		assertEquals(expected, resultBuilder.convertDivisionResultToString(divider));
	}
}
