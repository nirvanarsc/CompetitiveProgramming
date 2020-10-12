package leetcode.weekly_contests.weekly_203;

public class P_1563 {

    public int stoneGameV(int[] stoneValue) {
        final int n = stoneValue.length;
        final int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stoneValue[i];
        }
        return dfs(0, n, preSum, new Integer[n + 1][n + 1]);
    }

    private static int dfs(int i, int j, int[] preSum, Integer[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int res = 0;
        for (int k = i + 1; k < j; k++) {
            final int left = preSum[k] - preSum[i];
            final int right = preSum[j] - preSum[k];
            if (left < right) {
                res = Math.max(res, left + dfs(i, k, preSum, dp));
            } else if (left == right) {
                res = Math.max(res, Math.max(left + dfs(i, k, preSum, dp), right + dfs(k, j, preSum, dp)));
            } else {
                res = Math.max(res, right + dfs(k, j, preSum, dp));
            }
        }
        return dp[i][j] = res;
    }
}
