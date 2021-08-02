package lectures.lecture1;

import org.junit.Assert;
import org.junit.Test;

public class CounterTest {

    @Test
    public void getCorrectNextElementWithInitElement0() {
        Counter counter = new Counter(0);
        int currentResult = counter.getNextElement();

        Assert.assertEquals(1, currentResult);
    }

    @Test
    public void getCorrectNextElementWithInitElement1() {
        Counter counter = new Counter(0);

        for (int i = 0; i < 5; i++) {
            counter.getNextElement();

        }
        int currentResult = counter.getNextElement();

        Assert.assertEquals(0, currentResult);
    }
}