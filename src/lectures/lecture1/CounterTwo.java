package lectures.lecture1;

public class CounterTwo extends Counter{

    public CounterTwo(int i) {
        super(i);
    }

    @Override
    public int getNextElement() {
        return this.i += 2;
    }
}
