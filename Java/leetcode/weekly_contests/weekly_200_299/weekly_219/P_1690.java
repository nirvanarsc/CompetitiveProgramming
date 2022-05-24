package leetcode.weekly_contests.weekly_200_299.weekly_219;

public class P_1690 {

    static int[] pre;
    static int[][][] dp;
    static boolean[][][] seen;

    public int stoneGameVII(int[] stones) {
        final int n = stones.length;
        dp = new int[n][n][2];
        seen = new boolean[n][n][2];
        pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + stones[i - 1];
        }
        return dfs(0, n - 1, 1);
    }

    private static int dfs(int i, int j, int turn) {
        if (i >= j) {
            return 0;
        }
        if (seen[i][j][turn]) {
            return dp[i][j][turn];
        }
        final int mul = turn == 1 ? 1 : -1;
        final int a = dfs(i + 1, j, turn ^ 1) + (mul * (pre[j + 1] - pre[i + 1]));
        final int b = dfs(i, j - 1, turn ^ 1) + (mul * (pre[j] - pre[i]));
        seen[i][j][turn] = true;
        return dp[i][j][turn] = turn == 1 ? Math.max(a, b) : Math.min(a, b);
    }
}
