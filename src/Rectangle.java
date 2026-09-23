public class Rectangle implements Figure {
    private double height;
    private double width;
    private String fillColor;
    private String borderColor;

    public Rectangle(double height, double width, String fillColor, String borderColor) {
        this.height = height;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeter() {
        return 2 * (height + width);
    }

    @Override
    public double square() {
        return height * width;
    }

    @Override
    public String fillColor() {
        return fillColor;
    }

    @Override
    public String borderColor() {
        return borderColor;
    }
}
