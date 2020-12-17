

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class TestCalculator3 extends Assert{

	private int resultValue;
	private int firstValue;
	private int secondValue;
	private Calculator calculator = new Calculator();

	public TestCalculator3(int firstValue, int secondValue, int resultValue) {
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.resultValue = resultValue;
	}

	@Parameterized.Parameters(name = "{index}:sumOf({0}+{1})={2}")

	public static Iterable<Object[]> dataForTest() {
		return Arrays.asList(new Object[][] {	{ 36, 63, 2268 },
												{ 28, -65, -1820 },
												{ -83, -46, 3818 }
													});
	}
	@Test
	public void testGetMultiple() throws Exception {
		assertEquals(resultValue, calculator.getMultiple(firstValue, secondValue));
	}
	
}
