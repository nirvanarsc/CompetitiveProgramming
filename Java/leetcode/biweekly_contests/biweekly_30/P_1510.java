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
        for (int i = 1; i * i <= n; i++) {
            if (!dfs(n - i * i, dp)) {
                res = true;
                break;
            }
        }
        return dp[n] = res;
    }
}
