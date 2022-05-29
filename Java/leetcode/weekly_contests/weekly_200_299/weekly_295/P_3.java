package leetcode.weekly_contests.weekly_200_299.weekly_295;

public class P_3 {

    public int totalSteps(int[] nums) {
        final int n = nums.length;
        final int[] dp = new int[n];
        final int[] stack = new int[n];
        int res = 0;
        int stackIdx = 0;
        for (int i = n - 1; i >= 0; --i) {
            while (stackIdx > 0 && nums[i] > nums[stack[stackIdx - 1]]) {
                dp[i] = Math.max(dp[i] + 1, dp[stack[--stackIdx]]);
                res = Math.max(res, dp[i]);
            }
            stack[stackIdx++] = i;
        }
        return res;
    }
}
