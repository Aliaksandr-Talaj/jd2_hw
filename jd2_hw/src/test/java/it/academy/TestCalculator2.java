package by.academy.homework6;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class TestCalculator2 extends Assert{

	private int resultValue;
	private int firstValue;
	private int secondValue;
	private Calculator calculator = new Calculator();

	public TestCalculator2(int firstValue, int secondValue, int resultValue) {
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.resultValue = resultValue;
	}

	@Parameterized.Parameters(name = "{index}:sumOf({0}+{1})={2}")

	public static Iterable<Object[]> dataForTest() {
		return Arrays.asList(new Object[][] {	{ 54, 9, 6 },
												{ -72, -8, 9 },
												{306, 51, 6 }
													});
	}
	@Test
	public void testGetDivide() throws Exception {
		assertEquals(resultValue, calculator.getDivide(firstValue, secondValue));
	}
	
	
	
}
