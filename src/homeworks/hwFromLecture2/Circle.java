package homeworks.hwFromLecture2;

public class Circle implements Shape {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + this.radius +
                ", color=" + this.color +
                ", area=" + this.getArea() +
                "}";
    }
}
