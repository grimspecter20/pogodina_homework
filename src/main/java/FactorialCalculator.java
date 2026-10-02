public class FactorialCalculator {
    public static long calculate(int number) {
        long result = 1;
        int counter = 1;
        if (number < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }
        while (counter <= number) {
            result = result * counter;
            counter++;
        }
        return result;
    }
}

