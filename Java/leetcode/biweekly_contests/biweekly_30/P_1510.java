package leetcode.biweekly_contests.biweekly_30;

public class P_1510 {

    public boolean winnerSquareGame(int n) {
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
}
