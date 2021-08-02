package lectures.lecture2;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 1, 1, 1};

        int max = 0;

        for (int num : nums) {
            max = Math.max(num, max);
        }

        int[] occurs = new int[max + 1];

        for (int num : nums) {
            occurs[num]++;
        }

        for (int i = 0; i < occurs.length; i++) {
            if (occurs[i] > nums.length / 2) {
                System.out.println(i);
            }
        }
    }
}
