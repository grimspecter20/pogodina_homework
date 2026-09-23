
public class Main {
    public static void main(String[] args) {
        taskOne();
        taskTwo();
    }

    private static void taskOne() {
        Cat[] catArray = new Cat[4];

        catArray[0] = new Cat("Эся");
        catArray[1] = new Cat("Василий");
        catArray[2] = new Cat("Бусинка");
        catArray[3] = new Cat("Мелиса");

        Plate plate = new Plate(40);

        for (Cat cat : catArray) {
            cat.eatFromPlate(plate, 20);
        }

        for (Cat cat : catArray) {
            cat.isFeeded();
        }
    }

    private static void taskTwo() {
        Rectangle rectangle = new Rectangle(10, 15, "Красный", "Желтый");
        Circle circle = new Circle(40, "Белый", "Оранжевый");
        Triangle triangle = new Triangle(5, 10, 7, "Фиолетовый", "Желтый");
        rectangle.printInfo();
        circle.printInfo();
        triangle.printInfo();
    }
}