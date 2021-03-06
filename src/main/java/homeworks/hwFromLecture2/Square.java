package homeworks.hwFromLecture2;

public class Square implements Shape {
    private double a = 1.0;
    private String color = "red";

    public Square() {}

    public Square(double a) {
        if (a < 0) {
            throw new IllegalStateException("Side A can not be negative: " + a);
        }
        this.a = a;
    }

    public Square(double a, String color) {
        if (a < 0) {
            throw new IllegalStateException("Side A can not be negative: " + a);
        }
        this.a = a;
        this.color = color;
    }

    public double getA() {
        return this.a;
    }
    public String getColor() {
        return this.color;
    }

    public void setA(double a) {
        if (a < 0) {
            throw new IllegalStateException("Side A can not be negative: " + a);
        }
        this.a = a;
    }
    public void setColor(String color) {
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
