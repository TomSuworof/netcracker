package homeworks.hwFromLecture2;

import org.junit.Assert;
import org.junit.Test;

public class EllipseTest {

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

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfNegativeEllipse() {
        Shape negEllipse = new Ellipse(-1, -1);
        double negEllipseArea = negEllipse.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfGreenNegativeEllipse() {
        Shape negEllipse = new Ellipse(-1, -1, "Green");
        double negEllipseArea = negEllipse.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfANegativeEllipse() {
        Shape negEllipse = new Ellipse(-1, 1);
        double negEllipseArea = negEllipse.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfGreenANegativeEllipse() {
        Shape negEllipse = new Ellipse(-1, 1, "Green");
        double negEllipseArea = negEllipse.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfBNegativeEllipse() {
        Shape negEllipse = new Ellipse(1, -1);
        double negEllipseArea = negEllipse.getArea();
    }

    @Test(expected = IllegalStateException.class)
    public void catchErrorWhenGettingAreaOfGreenBNegativeEllipse() {
        Shape negEllipse = new Ellipse(1, -1, "Green");
        double negEllipseArea = negEllipse.getArea();
    }
}