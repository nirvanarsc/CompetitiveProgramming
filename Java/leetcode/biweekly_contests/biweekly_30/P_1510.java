package leetcode.biweekly_contests.biweekly_30;

public class P_1510 {

    public boolean winnerSquareGameOld(int n) {
        return dfs(n, new Boolean[n + 1]);
    }

    private static boolean dfs(int n, Boolean[] dp) {
        if (n == 0) {
            return false;
        }
        if (dp[n] != null) {
            return dp[n];
        }
        boolean res = false;
        for (int p = 1; p * p <= n; p++) {
            if (!dfs(n - p * p, dp)) {
                res = true;
                break;
            }
        }
        return dp[n] = res;
    }

    static boolean[][] seen;
    static int[][] dp;

    public boolean winnerSquareGame(int n) {
        seen = new boolean[n + 1][2];
        dp = new int[n + 1][2];
        return dfs(n, 0) == 0;
    }

    private static int dfs(int n, int turn) {
        if (n == 0) {
            return 1 ^ turn;
        }
        if (seen[n][turn]) {
            return dp[n][turn];
        }
        int res;
        if (turn == 0) {
            res = 1;
            for (int i = 1; i * i <= n; i++) {
                res = Math.min(res, dfs(n - i * i, 1));
            }
        } else {
            res = 0;
            for (int i = 1; i * i <= n; i++) {
                res = Math.max(res, dfs(n - i * i, 0));
            }
        }
        seen[n][turn] = true;
        return dp[n][turn] = res;
    }
}
