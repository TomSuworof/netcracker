package homeworks.hwForLecture3;

public class Ellipse implements Shape {
    private double a = 1.0;
    private double b = 1.0;
    private String color = "red";

    public Ellipse() {}

    public Ellipse(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return Math.PI * a * b;
    }
}
