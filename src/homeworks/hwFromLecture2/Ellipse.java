package homeworks.hwFromLecture2;

public class Ellipse implements Shape {
    private double a = 1.0;
    private double b = 1.0;
    private String color = "red";

    public Ellipse() {}

    public Ellipse(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Ellipse(double a, double b, String color) {
        this.a = a;
        this.b = b;
        this.color = color;
    }

    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public String getColor() {
        return this.color;
    }

    public void setA(double a) {
        this.a = a;
    }
    public void setB(double b) {
        this.b = b;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double getArea() {
        return Math.PI * a * b;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "a=" + this.a +
                ", b=" + this.b +
                ", color=" + this.color +
                ", area=" + this.getArea() +
                "}";
    }
}
