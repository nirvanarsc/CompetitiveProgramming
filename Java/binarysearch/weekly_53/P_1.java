package binarysearch.weekly_53;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public int[] solve(int[] nums) {
        final List<Integer> res = new ArrayList<>();
        if (nums.length > 1) {
            for (int i = 0; i < nums.length; i++) {
                if (f(nums, i)) {
                    res.add(i);
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean f(int[] nums, int i) {
        if (i == 0) {
            return nums[0] > nums[1];
        } else if (i == nums.length - 1) {
            return nums[i] > nums[i - 1];
        } else {
            return nums[i - 1] < nums[i] && nums[i] > nums[i + 1];
        }
    }
}
