package homeworks.hwFromLecture2;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

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

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfABCNegativeTriangle() {
        Shape negTriangle = new Triangle(-1, -1, -1);
        double negTriangleArea = negTriangle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfGreenABCNegativeTriangle() {
        Shape negTriangle = new Triangle(-1, -1, -1, "green");
        double negTriangleArea = negTriangle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfANegativeTriangle() {
        Shape negTriangle = new Triangle(-1, 1, 1);
        double negTriangleArea = negTriangle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfGreenANegativeTriangle() {
        Shape negTriangle = new Triangle(-1, 1, 1, "green");
        double negTriangleArea = negTriangle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfBNegativeTriangle() {
        Shape negTriangle = new Triangle(1, -1, 1);
        double negTriangleArea = negTriangle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfGreenBNegativeTriangle() {
        Shape negTriangle = new Triangle(1, -1, 1, "green");
        double negTriangleArea = negTriangle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfCNegativeTriangle() {
        Shape negTriangle = new Triangle(1, 1, -1);
        double negTriangleArea = negTriangle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfGreenCNegativeTriangle() {
        Shape negTriangle = new Triangle(1, 1, -1, "green");
        double negTriangleArea = negTriangle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfABNegativeTriangle() {
        Shape negTriangle = new Triangle(-1, -1, 1);
        double negTriangleArea = negTriangle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfGreenABNegativeTriangle() {
        Shape negTriangle = new Triangle(-1, -1, 1, "green");
        double negTriangleArea = negTriangle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfBCNegativeTriangle() {
        Shape negTriangle = new Triangle(1, -1, -1);
        double negTriangleArea = negTriangle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfGreenBCNegativeTriangle() {
        Shape negTriangle = new Triangle(1, -1, -1, "green");
        double negTriangleArea = negTriangle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfACNegativeTriangle() {
        Shape negTriangle = new Triangle(-1, 1, -1);
        double negTriangleArea = negTriangle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfGreenACNegativeTriangle() {
        Shape negTriangle = new Triangle(-1, 1, -1, "green");
        double negTriangleArea = negTriangle.getArea();
    }
}