public class ArrayValidator {
    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length == 4) {
            for (int i = 0; i < array.length; i++) {
                if ((array[i].length != 4)) {
                    throw new MyArraySizeException();
                }
            }
        } else throw new MyArraySizeException();

        int sum = 0;
        for (int i = 0; i <array.length; i++){
            for (int j = 0; j <array[i].length; j++){
                try {
                    sum = sum+Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
            }
        }
        return sum;
    }
}
