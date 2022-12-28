package leetcode.weekly_contests.weekly_300_399.weekly_323;

import java.util.Arrays;

public class P_2 {

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        final int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            final long v = (long) nums[i] * nums[i];
            final int idx = lowerBound(nums, v);
            if (idx != n && nums[idx] == v) {
                dp[idx] = Math.max(dp[idx], dp[i] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        res++;
        return res < 2 ? -1 : res;
    }

    private static int lowerBound(int[] arr, long target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
