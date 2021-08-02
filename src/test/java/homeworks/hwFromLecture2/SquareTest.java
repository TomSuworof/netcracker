package homeworks.hwFromLecture2;

import org.junit.Assert;
import org.junit.Test;

public class SquareTest {

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

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfNegativeSquare() {
        Shape negSquare = new Square(-1);
        double negSquareArea = negSquare.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfGreenNegativeSquare() {
        Shape negSquare = new Square(-1, "Green");
        double negSquareArea = negSquare.getArea();
    }
}