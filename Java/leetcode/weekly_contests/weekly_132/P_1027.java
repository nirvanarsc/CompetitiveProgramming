package leetcode.weekly_contests.weekly_132;

public class P_1027 {

    public int longestArithSeqLength(int[] ints) {
        int res = 2;
        final int n = ints.length;
        final int[][] dp = new int[n][20001];
        for (int j = 0; j < ints.length; j++) {
            for (int i = 0; i < j; i++) {
                final int d = ints[j] - ints[i] + 10001;
                if (dp[i][d] == 0) {
                    dp[j][d] = 2;
                } else {
                    dp[j][d] = dp[i][d] + 1;
                }
                res = Math.max(res, dp[j][d]);
            }
        }
        return res;
    }

    // TLE 34/35
    public static int longestArithSeqLengthTopDown(int[] nums) {
        return recurse(nums, -1, -1, 0, new Integer[nums.length][nums.length]);
    }

    public static int recurse(int[] nums, int prevprev, int prev, int start, Integer[][] dp) {
        if (start == nums.length) {
            return 0;
        }
        if (prevprev != -1 && prev != -1 && dp[prevprev][prev] != null) {
            return dp[prevprev][prev];
        }
        int take = 0;
        if (prevprev < 0 || prev < 0 || nums[prev] - nums[prevprev] == nums[start] - nums[prev]) {
            take = 1 + recurse(nums, prev, start, start + 1, dp);
        }
        final int skip = recurse(nums, prevprev, prev, start + 1, dp);
        if (prevprev != -1 && prev != -1) {
            dp[prevprev][prev] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
}
