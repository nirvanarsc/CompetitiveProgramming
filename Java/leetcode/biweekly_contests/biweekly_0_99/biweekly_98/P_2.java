package leetcode.biweekly_contests.biweekly_0_99.biweekly_98;

import java.util.Arrays;

public class P_2 {

    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        int res = (int) 1e9;
        res = Math.min(res, nums[n - 1] - nums[2]);
        res = Math.min(res, nums[n - 2] - nums[1]);
        res = Math.min(res, nums[n - 3] - nums[0]);
        return res;
    }
}
