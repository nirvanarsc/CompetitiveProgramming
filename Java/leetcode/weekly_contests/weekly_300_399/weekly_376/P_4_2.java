package leetcode.weekly_contests.weekly_300_399.weekly_376;

import java.util.Arrays;

public class P_4_2 {

    public int maxFrequencyScore(int[] nums, long k) {
        final int n = nums.length;
        Arrays.sort(nums);
        int j = 0;
        int res = 0;
        long curr = 0;
        for (int i = 0; i < n; ++i) {
            curr += nums[i] - nums[(j + i) / 2];
            while (curr > k) {
                curr -= nums[(j + i + 1) / 2] - nums[j++];
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
