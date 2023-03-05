package leetcode.weekly_contests.weekly_300_399.weekly_335;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public int waysToReachTarget(int target, int[][] types) {
        final int n = types.length;
        final int[][] dp = new int[target + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i < target; i++) {
            for (int j = 0; j < n; j++) {
                for (int u = 0; u <= types[j][0]; u++) {
                    if (i + u * types[j][1] > target) {
                        break;
                    }
                    dp[i + u * types[j][1]][j + 1] = (dp[i + u * types[j][1]][j + 1] + dp[i][j]) % MOD;
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res = (res + dp[target][i]) % MOD;
        }
        return res;
    }
}
