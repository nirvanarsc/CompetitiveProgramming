package leetcode.medium;

import java.util.Arrays;

public class P_62 {

    public int uniquePaths2(int m, int n) {
        final int[] dp = new int[m];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[m - 1];
    }

    public int uniquePaths(int m, int n) {
        final int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
