import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticCalculatorTest {
    @ParameterizedTest
    @CsvSource({
            "5,3,8",
            "5,0,5",
            "-5,3,-2"
    })
    void addTest(int addend1, int addend2, int expected) {
        assertEquals(expected, ArithmeticCalculator.add(addend1, addend2));
    }

    @ParameterizedTest
    @CsvSource({
            "5,3,2",
            "5,0,5",
            "-5,3,-8"
    })
    void subtractTest(int minuend, int subtrahend, int expected) {
        assertEquals(expected, ArithmeticCalculator.subtract(minuend, subtrahend));
    }

    @ParameterizedTest
    @CsvSource({
            "6,3,2",
            "5,2,2.5",
            "0,5,0",
            "-6,2,-3"
    })
    void divideTest(int dividend, int divisor, double expected) {
        assertEquals(expected, ArithmeticCalculator.divide(dividend, divisor), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "2,3,6",
            "0,5,0",
            "-5,3,-15",
    })
    void multiplyTest(int multiplier1, int multiplier2, int expected) {
        assertEquals(expected, ArithmeticCalculator.multiply(multiplier1, multiplier2));
    }
}
