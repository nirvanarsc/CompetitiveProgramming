package leetcode.weekly_contests.weekly_59;

public class P_730 {

    private static final int MOD = (int) (1e9 + 7);

    @SuppressWarnings("MethodParameterNamingConvention")
    public int countPalindromicSubsequences(String S) {
        final int n = S.length();
        final int[][][] dp = new int[4][n][n];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                for (int k = 0; k < 4; ++k) {
                    final char c = (char) ('a' + k);
                    if (j == i) {
                        dp[k][i][j] = S.charAt(i) == c ? 1 : 0;
                    } else {
                        if (S.charAt(i) != c) {
                            dp[k][i][j] = dp[k][i + 1][j];
                        } else if (S.charAt(j) != c) {
                            dp[k][i][j] = dp[k][i][j - 1];
                        } else {
                            if (j == i + 1) {
                                dp[k][i][j] = 2;
                            } else {
                                dp[k][i][j] = 2;
                                for (int m = 0; m < 4; ++m) {
                                    dp[k][i][j] = (dp[k][i][j] + dp[m][i + 1][j - 1]) % MOD;
                                }
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int k = 0; k < 4; ++k) {
            ans = (ans + dp[k][0][n - 1]) % MOD;
        }
        return ans;
    }
}
