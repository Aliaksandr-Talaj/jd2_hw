

import org.junit.runner.JUnitCore;

public class AllTestsCalculatorWithListener {
	public static void main(String[] args) {
		JUnitCore core = new JUnitCore();
		core.addListener(new CalculatorTestListener());
		core.run(TestCalculator1.class, TestCalculator2.class, TestCalculator3.class);
	}
}
