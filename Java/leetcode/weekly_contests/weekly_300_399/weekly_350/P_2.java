package leetcode.weekly_contests.weekly_300_399.weekly_350;

import java.util.Arrays;

public class P_2 {

    public int findValueOfPartition(int[] nums) {
        final int n = nums.length;
        int res = (int) 2e9;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            res = Math.min(res, nums[i + 1] - nums[i]);
        }
        return res;
    }
}
