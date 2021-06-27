package leetcode.weekly_contests.weekly_247;

import java.util.Arrays;

public class P_1 {

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        return nums[n - 1] * nums[n - 2] - (nums[0] * nums[1]);
    }
}
