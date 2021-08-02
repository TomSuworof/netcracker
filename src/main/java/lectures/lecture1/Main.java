package lectures.lecture1;

public class Main {
    public static void main(String[] args) {
        lectures.lecture1.Counter counter = new lectures.lecture1.Counter(0);

        System.out.println("Current value is " + counter.getNextElement());

        lectures.lecture1.Counter two = new lectures.lecture1.CounterTwo(0);

        System.out.println(two);

    }
}
