package homeworks.hwForLecture3;

public class Square implements Shape {
    private double a = 1.0;
    private String color = "red";

    public Square() {}

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double getArea() {
        return Math.pow(a, 2);
    }
}
