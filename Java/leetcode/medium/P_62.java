package leetcode.medium;

import java.util.Arrays;

public class P_62 {

    static int[][] dp;
    static boolean[][] seen;
    static int lr;
    static int lc;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        seen = new boolean[m][n];
        lr = m - 1;
        lc = n - 1;
        return dfs(0, 0);
    }

    private static int dfs(int r, int c) {
        if (r > lr || c > lc) {
            return 0;
        }
        if (r == lr && c == lc) {
            return 1;
        }
        if (seen[r][c]) {
            return dp[r][c];
        }
        seen[r][c] = true;
        return dp[r][c] = dfs(r + 1, c) + dfs(r, c + 1);
    }

    public int uniquePathsBottomUp(int m, int n) {
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
