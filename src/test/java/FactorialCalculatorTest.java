import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialCalculatorTest {
    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {0, 1L},
                {1, 1L},
                {5, 120L}
        };
    }

    @Test(dataProvider = "factorialData")
    public void factorialTest(int number, long expected) {
        assertEquals(FactorialCalculator.calculate(number), expected);
    }
}
