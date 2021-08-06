package lectures.lecture15;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{3, 0, 1})); // 2
        System.out.println(solve(new int[]{0, 1})); // 2
    }

    private static int solve(int[] nums) {
        int ourSum = 0;

        for (int num : nums) {
            ourSum += num;
        }

        int requiredSum = (nums.length * (nums.length + 1)) / 2;

        return requiredSum - ourSum;
    }
}
