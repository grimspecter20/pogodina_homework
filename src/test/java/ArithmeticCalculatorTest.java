import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArithmeticCalculatorTest {
    @DataProvider(name = "addData")
    public Object[][] addData() {
        return new Object[][]{
                {5, 3, 8},
                {5, 0, 5},
                {-5, 3, -2}
        };
    }

    @Test(dataProvider = "addData")
    public void addTest(int addend1, int addend2, int expected) {
        assertEquals(ArithmeticCalculator.add(addend1, addend2), expected);
    }

    @DataProvider(name = "subtractData")
    public Object[][] subtractData() {
        return new Object[][]{
                {5, 3, 2},
                {5, 0, 5},
                {-5, 3, -8}
        };
    }

    @Test(dataProvider = "subtractData")
    public void subtractTest(int minuend, int subtrahend, int expected) {
        assertEquals(ArithmeticCalculator.subtract(minuend, subtrahend), expected);
    }

    @DataProvider(name = "divideData")
    public Object[][] divideData() {
        return new Object[][]{
                {6, 3, 2},
                {5, 2, 2.5},
                {0, 5, 0},
                {-6, 2, -3}
        };
    }

    @Test(dataProvider = "divideData")
    public void divideTest(int dividend, int divisor, double expected) {
        assertEquals(ArithmeticCalculator.divide(dividend, divisor), expected, 0.001);
    }

    @DataProvider(name = "multiplyData") // Тут бы дописал в нейминги тест, типа multiplyTestData
    public Object[][] multiplyData() {
        return new Object[][]{
                {2, 3, 6},
                {0, 5, 0},
                {-5, 3, -15}
        };
    }

    @Test(dataProvider = "multiplyData")
    public void multiplyTest(int multiplier1, int multiplier2, int expected) {
        assertEquals(ArithmeticCalculator.multiply(multiplier1, multiplier2), expected);
    }
}
