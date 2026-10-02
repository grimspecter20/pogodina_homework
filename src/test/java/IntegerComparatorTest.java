import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IntegerComparatorTest {

    @DataProvider(name = "compareData")
    public Object[][] compareData() {
        return new Object[][]{
                {5, 3, ResultOfCompare.FIRST_GREATER},
                {5, 5, ResultOfCompare.NUMBERS_EQUAL},
                {3, 5, ResultOfCompare.FIRST_LESS}
        };
    }

    @Test(dataProvider = "compareData")
    public void compareTest(int number1, int number2, ResultOfCompare expected) {
        assertEquals(IntegerComparator.compare(number1, number2), expected);
    }
}