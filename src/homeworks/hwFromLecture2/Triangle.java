package homeworks.hwFromLecture2;

public class Triangle implements Shape {
    private double a = 1.0;
    private double b = 1.0;
    private double c = 1.0;
    private String color = "red";

    public Triangle() {}

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(double a, double b, double c, String color) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.color = color;
    }

    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public double getC() {
        return this.c;
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
    public void setC(double c) {
        this.c = c;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double getArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + this.a +
                ", b=" + this.b +
                ", c=" + this.c +
                ", color=" + this.color +
                ", area=" + this.getArea() +
                "}";
    }
}
