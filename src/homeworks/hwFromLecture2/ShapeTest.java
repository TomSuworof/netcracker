package homeworks.hwFromLecture2;

import org.junit.Assert;
import org.junit.Test;

public class ShapeTest {

    @Test
    public void getCorrectAreaOfUnitCircle() {
        Shape unitCircle = new Circle();
        double unitCircleArea = unitCircle.getArea();

        Assert.assertEquals(Math.PI, unitCircleArea, 0);
    }

    @Test
    public void getCorrectAreaOfGreenUnitCircle() {
        Shape unitCircle = new Circle(1, "green");
        double unitCircleArea = unitCircle.getArea();

        Assert.assertEquals(Math.PI, unitCircleArea, 0);
    }

    @Test
    public void getCorrectAreaOfUnitSquare() {
        Shape unitSquare = new Square();
        double unitSquareArea = unitSquare.getArea();

        Assert.assertEquals(1, unitSquareArea, 0);
    }

    @Test
    public void getCorrectAreaOfGreenUnitSquare() {
        Shape unitSquare = new Square(1, "green");
        double unitSquareArea = unitSquare.getArea();

        Assert.assertEquals(1, unitSquareArea, 0);
    }

    @Test
    public void getCorrectAreaOfUnitEllipse() {
        Shape unitEllipse = new Ellipse(); // like a circle
        double unitEllipseArea = unitEllipse.getArea();

        Assert.assertEquals(Math.PI, unitEllipseArea, 0);
    }

    @Test
    public void getCorrectAreaOfGreenUnitEllipse() {
        Shape unitEllipse = new Ellipse(1, 1, "green"); // like a circle
        double unitEllipseArea = unitEllipse.getArea();

        Assert.assertEquals(Math.PI, unitEllipseArea, 0);
    }

    @Test
    public void getCorrectAreaOfEllipse() {
        Shape ellipse = new Ellipse(1, 2);
        double ellipseArea = ellipse.getArea();

        Assert.assertEquals(2 * Math.PI, ellipseArea, 0);
    }

    @Test
    public void getCorrectAreaOfGreenEllipse() {
        Shape ellipse = new Ellipse(1, 2, "green");
        double ellipseArea = ellipse.getArea();

        Assert.assertEquals(2 * Math.PI, ellipseArea, 0);
    }

    @Test
    public void getCorrectAreaOfUnitTriangle() {
        Shape unitTriangle = new Triangle();
        double unitTriangleArea = unitTriangle.getArea();

        Assert.assertEquals(Math.sqrt(3) / 4, unitTriangleArea, 0);
    }

    @Test
    public void getCorrectAreaOfGreenUnitTriangle() {
        Shape unitTriangle = new Triangle(1, 1, 1, "green");
        double unitTriangleArea = unitTriangle.getArea();

        Assert.assertEquals(Math.sqrt(3) / 4, unitTriangleArea, 0);
    }

    @Test
    public void getCorrectAreaOfPythagorasTriangle() {
        Shape triangle = new Triangle(3, 4, 5);
        double triangleArea = triangle.getArea();

        Assert.assertEquals(6, triangleArea, 0);
    }

    @Test
    public void equalsCircleAndEllipse() {
        double a = 1;

        Shape unitCircle = new Circle(a);
        Shape unitEllipse = new Ellipse(a, a);

        Assert.assertEquals(unitCircle.getArea(), unitEllipse.getArea(), 0);
    }
}