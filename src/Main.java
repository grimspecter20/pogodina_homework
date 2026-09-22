
public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        isSumInRange(10, 1);
        printNumberSign(-3);
        isNegative(-3);
        printStringMultipleTimes("I love Java", 3);
        isLeapYear(2004);
        invertArray();
        fillArray();
        multiplyLessThanSix();
        createAndFillDiagonal();
        newArray(2, 3);
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {

        int a = 4;
        int b = 10;

        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else if ((a + b) < 0) {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {

        int value = 101;

        if (value <= 0) {
            System.out.println("Красный");
        } else if ((value > 0) && (value <= 100)) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }

    }

    public static void compareNumbers() {

        int a = 1;
        int b = 9;

        if (a >= b) {
            System.out.println("a >= b");
        } else System.out.println("a < b");
    }

    public static boolean isSumInRange(int a, int b) {

        int sum = a + b;
        return ((sum >= 10) && (sum <= 20));
    }

    public static void printNumberSign(int number) {

        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean isNegative(int number) {

        if (number >= 0) {
            return false;
        } else {
            return true;
        }

    }

    public static void printStringMultipleTimes(String text, int count) {

        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static boolean isLeapYear(int year) {

        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));

    }

    public static void invertArray() {

        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }

    public static void fillArray() {

        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public static void multiplyLessThanSix() {

        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
    }


    public static void createAndFillDiagonal() {

        int[][] array = new int[10][10];

        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - 1 - i] = 1;
        }
    }

    public static int[] newArray(int len, int initialValue) {

        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }

        return array;

    }

}



