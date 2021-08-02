package homeworks.hwFromLecture2;

import org.junit.Assert;
import org.junit.Test;

public class CircleAndEllipseTest {

    @Test
    public void equalsCircleAndEllipseArea() {
        double a = 1;

        Shape unitCircle = new Circle(a);
        Shape unitEllipse = new Ellipse(a, a);

        Assert.assertEquals(unitCircle.getArea(), unitEllipse.getArea(), 0);
    }
}