package it.academy;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)

public class TestCalculator1 extends Assert {

	private int resultValue;
	private int firstValue;
	private int secondValue;
	private Calculator calculator = new Calculator();

	public TestCalculator1(int firstValue, int secondValue, int resultValue) {
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.resultValue = resultValue;
	}

	@Parameterized.Parameters(name = "{index}:sumOf({0}+{1})={2}")

	public static Iterable<Object[]> dataForTest() {
		return Arrays.asList(new Object[][] {	{ 15, 18, 33 },
												{ 14, -8, 6 },
												{ 55, 66, 121 }
													});
	}

	@Test
	public void testGetSum() throws Exception {
		assertEquals(resultValue, calculator.getSum(firstValue, secondValue));
	}

}
