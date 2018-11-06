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
		String expected = 
		"_0 |-10\n" + 
		"-10|---\n" + 
		" --|0\n" + 
		"  0";
				
		assertEquals(expected, resultBuilder.convertDivisionResultToString(divider));
	}

	@Test
	public void shouldReturnCorrectResult_whenDivideNegativeNumberByNegativeNumber() {
		divider.performIntegerDivision(-200200, -10);
		String expected = 
		"-200200|-10\n" + 
		"-10    |-----\n" + 
		" --    |20020\n" + 
		"_20\n" + 
		" 20\n" + 
		" --\n" + 
		" _0\n" + 
		"  0\n" + 
		"  -\n" + 
		"   0";
		assertEquals(expected, resultBuilder.convertDivisionResultToString(divider));
	}

	@Test
	public void shouldReturnCorrectResult_whenDivideNegativeNumberByPositiveNumber() {
		divider.performIntegerDivision(-200200, 1000);
		String expected = 
		"-200200|1000\n" + 
		" 1000  |----\n" + 
		" ----  |-200\n" + 
		"_200\n" + 
		" 0\n" + 
		" -\n" + 
		"  -200";
		assertEquals(expected, resultBuilder.convertDivisionResultToString(divider));
	}

	@Test
	public void shouldReturnCorrectResult_whenDividePositiveNumberByPositiveNumber() {
		divider.performIntegerDivision(78945, 4);
		String expected = 
		"_78945|4\n" + 
		" 4    |-----\n" + 
		" -    |19736\n" + 
		"_39\n" + 
		" 36\n" + 
		" --\n" + 
		" _34\n" + 
		"  32\n" + 
		"  --\n" + 
		"  _25\n" + 
		"   24\n" + 
		"   --\n" + 
		"    1";
		assertEquals(expected, resultBuilder.convertDivisionResultToString(divider));
	}

	@Test
	public void shouldReturnCorrectResult_whenDividePositiveNumberByOne() {
		divider.performIntegerDivision(10000000, 1);
		String expected = 
		"_10000000|1\n" + 
		" 1       |--------\n" + 
		" -       |10000000\n" + 
		"_0\n" + 
		" 0\n" + 
		" -\n" + 
		"       0";
		assertEquals(expected, resultBuilder.convertDivisionResultToString(divider));
	}
	
	@Test
	public void shouldReturnCorrectResult_whenDivideOneByNegativeOne() {
		divider.performIntegerDivision(1, -1);
		String expected = 
		"_1|-1\n" + 
		"-1|--\n" + 
		" -|-1\n" + 
		" 0";
		assertEquals(expected, resultBuilder.convertDivisionResultToString(divider));
	}
}
