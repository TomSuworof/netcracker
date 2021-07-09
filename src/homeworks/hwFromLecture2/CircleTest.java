package homeworks.hwFromLecture2;

import org.junit.Assert;
import org.junit.Test;

public class CircleTest {

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

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfNegativeCircle() {
        Shape negCircle = new Circle(-1);
        double negCircleArea = negCircle.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfGreenNegativeCircle() {
        Shape negCircle = new Circle(-1, "Green");
        double negCircleArea = negCircle.getArea();
    }
}