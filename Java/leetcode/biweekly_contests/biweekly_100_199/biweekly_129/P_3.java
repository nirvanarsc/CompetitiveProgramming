package leetcode.biweekly_contests.biweekly_100_199.biweekly_129;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int numberOfStableArrays(int zero, int one, int limit) {
        final int[][][] dp = new int[zero + 1][one + 1][2];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                for (int k = 1; k <= limit && k <= i; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - k][j][1]) % MOD;
                }
                for (int k = 1; k <= limit && k <= j; k++) {
                    dp[i][j][1] = (dp[i][j][1] + dp[i][j - k][0]) % MOD;
                }
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}
