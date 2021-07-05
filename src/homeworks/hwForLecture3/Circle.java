package homeworks.hwForLecture3;

public class Circle implements Shape {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {}

    public Circle(double r) {
        this.radius = r;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
