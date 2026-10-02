import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleAreaCalculatorTest {
    @DataProvider(name = "triangleData")
    public Object[][] triangleData() {
        return new Object[][]{
                {3.0, 4.0, 5.0, 6.0},
                {2.0, 2.0, 2.0, 1.7320508075688772},
                {2.5, 3.5, 4.0, 4.330127018922193}
        };
    }

    @Test(dataProvider = "triangleData")
    public void squareTest(double a, double b, double c, double expected) {
        assertEquals(TriangleAreaCalculator.square(a, b, c), expected, 0.001);
    }
}
