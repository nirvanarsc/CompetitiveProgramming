package binarysearch.weekly_28;

import java.util.Arrays;

public class P_1 {

    public int solve(int[] nums, int k) {
        Arrays.sort(nums);
        final int t = nums.length - k;
        int res = (int) 2e9;
        for (int i = 0; i < nums.length - t + 1; i++) {
            res = Math.min(res, nums[i + t - 1] - nums[i]);
        }
        return res;
    }
}
