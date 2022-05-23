package leetcode.weekly_contests.weekly_12;

public class P_474 {

    public int findMaxForm(String[] strs, int m, int n) {
        final int l = strs.length;
        final int[][] f = new int[l][2];
        final int[][][] dp = new int[l + 1][m + 1][n + 1];
        for (int i = 0; i < l; i++) {
            for (char c : strs[i].toCharArray()) {
                f[i][c - '0']++;
            }
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j <= m - f[i][0] && k <= n - f[i][1]) {
                        dp[i + 1][j + f[i][0]][k + f[i][1]] = Math.max(dp[i + 1][j + f[i][0]][k + f[i][1]],
                                                                       dp[i][j][k] + 1);
                    }
                    dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k]);
                }
            }
        }
        return dp[l][m][n];
    }
}
