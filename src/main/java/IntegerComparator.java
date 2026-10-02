public class IntegerComparator {
    public static ResultOfCompare compare(int number1, int number2) {
        if (number1 > number2) {
            return ResultOfCompare.FIRST_GREATER;
        } else if (number1 == number2) {
            return ResultOfCompare.NUMBERS_EQUAL;
        } else return ResultOfCompare.FIRST_LESS;
    }
}
