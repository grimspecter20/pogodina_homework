import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerComparatorTest {

    @ParameterizedTest
    @CsvSource({
            "5, 3, FIRST_GREATER",
            "5, 5, NUMBERS_EQUAL",
            "3, 5, FIRST_LESS"
    })
    void compareTest(int number1, int number2, ResultOfCompare expected) {
        assertEquals(expected, IntegerComparator.compare(number1, number2));
    }
}
