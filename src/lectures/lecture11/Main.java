package lectures.lecture11;

public class Main {
    public static void main(String[] args) {
        System.out.println(toString(new int[]{1, 2, 3}));

        Function f = new Function();
        for (double i = 0; i < 50; i++) {
            double j = f.getY(i);
        }
        System.out.println(f);
    }

    public static String toString(int[] nums) {
        StringBuilder str = new StringBuilder("[");

        for (int num : nums) {
            str.append(num).append(", ");
        }

        str = new StringBuilder(str.subSequence(0, str.length() - 2)).append("]");
        return str.toString();
    }
}
