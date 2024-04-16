package leetcode.weekly_contests.weekly_300_399.weekly_392;

import java.util.Arrays;

public class P_3 {

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        final int n = nums.length;
        long res = 0;
        if (k > nums[n / 2]) {
            for (int i = n / 2; i < n; i++) {
                res += Math.max(0, k - nums[i]);
            }
        } else {
            for (int i = 0; i <= n / 2; i++) {
                res += Math.max(0, nums[i] - k);
            }
        }
        return res;
    }
}
