package leetcode.biweekly_contests.biweekly_97;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public boolean isPossibleToCutPath(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] g1 = new int[n][m];
        g1[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (i > 0) {
                        g1[i][j] = (g1[i][j] + g1[i - 1][j]) % MOD;
                    }
                    if (j > 0) {
                        g1[i][j] = (g1[i][j] + g1[i][j - 1]) % MOD;
                    }
                }
            }
        }
        final int[][] g2 = new int[n][m];
        g2[n - 1][m - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    if (i < n - 1) {
                        g2[i][j] = (g2[i][j] + g2[i + 1][j]) % MOD;
                    }
                    if (j < m - 1) {
                        g2[i][j] = (g2[i][j] + g2[i][j + 1]) % MOD;
                    }
                }
            }
        }
        final int total = g1[n - 1][m - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == n - 1 && j == m - 1) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    final long curr = ((long) g1[i][j] * g2[i][j]) % MOD;
                    if (curr == total) {
                        return true;
                    }
                }
            }
        }
        return total == 0;
    }
}
