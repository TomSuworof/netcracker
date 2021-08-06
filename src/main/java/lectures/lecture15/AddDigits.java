package lectures.lecture15;

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(solveUsingString(38)); // 2
        System.out.println(solveUsingString(0)); // 0

        System.out.println();

        System.out.println(solve(38)); // 2
        System.out.println(solve(0)); // 0
    }

    private static int solveUsingString(int num) {
        String result = String.valueOf(num);

        while (result.length() > 1) {
            int sum = 0;
            for (char c : result.toCharArray()) {
                sum += Character.getNumericValue(c);
            }
            result = String.valueOf(sum);
        }

        return Integer.parseInt(result);
    }

    private static int solve(int num) {
        while (num >= 10) {
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            num = sum;
        }
        return num;
    }
}
