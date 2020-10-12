package leetcode.biweekly_contests.biweekly_30;

import java.util.Arrays;

public class P_1509 {

    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length - 1;
        return diff(nums, 0, n, Math.min(3, n));
    }

    private static int diff(int[] nums, int i, int j, int k) {
        if (k == 0) {
            return nums[j] - nums[i];
        }
        final int takeLow = diff(nums, i + 1, j, k - 1);
        final int takeHigh = diff(nums, i, j - 1, k - 1);
        return Math.min(takeLow, takeHigh);
    }
}
