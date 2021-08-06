package lectures.lecture15;

import java.util.*;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(solveLogN(new int[]{1, 3, 5, 6}, 5)); // 2
        System.out.println(solveLogN(new int[]{1, 3, 5, 6}, 2)); // 1
        System.out.println(solveLogN(new int[]{1, 3, 5, 6}, 7)); // 4
    }

    private static int solve(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();

        Arrays.stream(nums).forEach(set::add);
        set.add(target);

        List<Integer> ints = new ArrayList<>(set);

        return ints.indexOf(target);
    }

    private static int solveLogN(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start < end - 1) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] < target) {
            return start + 1;
        } else {
            return start;
        }
    }
}
