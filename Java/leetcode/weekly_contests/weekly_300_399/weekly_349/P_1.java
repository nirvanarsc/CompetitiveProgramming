package leetcode.weekly_contests.weekly_300_399.weekly_349;

import java.util.Arrays;

public class P_1 {

    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[1];
    }
}
