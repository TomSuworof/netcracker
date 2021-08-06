package lectures.lecture15;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{7, 1, 5, 3, 4, 6})); // 5
        System.out.println(solve(new int[]{7, 6, 4, 3, 1})); // 0
    }

    private static int solve(int[] nums) {
        int maxProfit = 0;

        int bought = nums[0];

        for (int num : nums) {
            bought = Math.min(bought, num);
            maxProfit = Math.max(maxProfit, num - bought);
        }

        return maxProfit;
    }
}
