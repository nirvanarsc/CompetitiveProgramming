package leetcode.weekly_contests.weekly_200_299.weekly_256;

import java.util.Arrays;

public class P_1 {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = (int) 1e9;
        for (int i = 0; i <= nums.length - k; i++) {
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        }
        return res;
    }
}
