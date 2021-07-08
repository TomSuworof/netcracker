package homeworks.hwFromLecture2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(10, "green");
        Shape square = new Square(4, "magenta");
        Shape ellipse = new Ellipse(10, 12, "purple");
        Shape triangle = new Triangle(3, 4, 5);

        List<Shape> shapes = Arrays.asList(circle, square, ellipse, triangle);

        shapes.forEach(System.out::println);
    }
}
