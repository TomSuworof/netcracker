package lectures.lecture1;

public class Counter implements CounterInterface {
    protected int i;

    public Counter(int i) {
        this.i = i;
    }

    public int getNextElement() {
        if (i >= 5) {
            i = 0;
            return i;
        }

        return ++i;
    }
}
