public interface Figure {
    double perimeter();

    double square();

    String fillColor();

    String borderColor();

    default void printInfo() {
        System.out.println("Фигура: " + getClass().getSimpleName() + ", периметр: " + perimeter() + ", площадь: " + square() + ", цвет фона: " + fillColor() + ", цвет границ: " + borderColor());
    }
}

