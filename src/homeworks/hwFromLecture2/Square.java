package homeworks.hwFromLecture2;

public class Square implements Shape {
    private double a = 1.0;
    private String color = "red";

    public Square() {}

    public Square(double a) {
        this.a = a;
    }

    public Square(double a, String color) {
        this.a = a;
        this.color = color;
    }


    @Override
    public double getArea() {
        return Math.pow(a, 2);
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + this.a +
                ", color=" + this.color +
                ", area=" + this.getArea() +
                "}";
    }
}
