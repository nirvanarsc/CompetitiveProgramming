package leetcode.weekly_contests.weekly_219;

public class P_1690 {

    public int stoneGameVII(int[] stones) {
        final int n = stones.length;
        final int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + stones[i - 1];
        }
        return dfs(pre, 0, n - 1, 1, new Integer[n][n][2]);
    }

    private static int dfs(int[] pre, int i, int j, int turn, Integer[][][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j][turn] != null) {
            return dp[i][j][turn];
        }
        final int res;
        if (turn == 1) {
            final int a = dfs(pre, i + 1, j, 0, dp) + pre[j + 1] - pre[i + 1];
            final int b = dfs(pre, i, j - 1, 0, dp) + pre[j] - pre[i];
            res = Math.max(a, b);
        } else {
            final int a = dfs(pre, i + 1, j, 1, dp) - (pre[j + 1] - pre[i + 1]);
            final int b = dfs(pre, i, j - 1, 1, dp) - (pre[j] - pre[i]);
            res = Math.min(a, b);
        }
        return dp[i][j][turn] = res;
    }
}
