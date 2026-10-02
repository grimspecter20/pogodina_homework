import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {
    @Test
    void factorialNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculate(-5);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "5, 120"
    })
    void factorialTest(int number, long expected) {
        assertEquals(expected, FactorialCalculator.calculate(number));
    }
}
