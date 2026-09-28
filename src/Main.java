
public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4", "5"},
                {"5", "6", "кот", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            System.out.println(ArrayValidator.sumArray(array));
        } catch (MyArraySizeException e) {
            System.out.println("Неправильная размерность массива");
        } catch (MyArrayDataException e) {
            System.out.println("В ячейке находится не числовое значение");
        }

        int[] testArray = new int[5];
        try {
            int i = testArray[6];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Несуществующий индекс");
        }
    }
}
