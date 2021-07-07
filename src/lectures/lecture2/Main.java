package lectures.lecture2;

public class Main {
    public static void main(String[] args) {
        Integer a = new Integer(5);
        Integer b = new Integer(5);

        System.out.println(a == b);

        System.out.println(a.equals(b));

        int[] numbers = {2, 2, 4};

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
