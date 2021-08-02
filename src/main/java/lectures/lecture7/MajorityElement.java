package lectures.lecture7;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 1, 1, 1};

        Map<Integer, Integer> occurs = new HashMap<>();

        for (int num : nums) {
            if (occurs.containsKey(num)) {
                occurs.put(num, occurs.get(num) + 1);
            } else {
                occurs.put(num, 1);
            }
        }

        boolean hasNumber = false;
        for (Map.Entry<Integer, Integer> entry : occurs.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                System.out.println(entry.getKey());
                hasNumber = true;
                break;
            }
        }
        if (!hasNumber) {
            System.out.println("No such number");
        }
    }
}
