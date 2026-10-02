import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleAreaCalculatorTest {
    @ParameterizedTest
    @CsvSource({
            "3, 4, 5, 6",
            "2, 2, 2, 1.7320508075688772",
            "2.5, 3.5, 4, 4.330127018922194"
    })
    void squareTest(double a, double b, double c, double expected) {
        assertEquals(expected, TriangleAreaCalculator.square(a, b, c), 0.0001);
    }
}
