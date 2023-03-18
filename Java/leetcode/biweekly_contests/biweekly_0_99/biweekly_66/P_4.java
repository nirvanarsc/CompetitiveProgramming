package leetcode.biweekly_contests.biweekly_0_99.biweekly_66;

public class P_4 {

    public int countPyramids(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        int[][] dp1 = new int[n][m];
        int[][] dp2 = new int[n][m];
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i - 1][j] == 1 && grid[i][j] == 1 && grid[i][j - 1] == 1) {
                    dp1[i][j] = 1 + Math.min(dp1[i - 1][j], dp1[i][j - 1]);
                }

            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = m - 2; j >= 0; j--) {
                if (grid[i - 1][j] == 1 && grid[i][j] == 1 && grid[i][j + 1] == 1) {
                    dp2[i][j] = 1 + Math.min(dp2[i - 1][j], dp2[i][j + 1]);
                }

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res += Math.min(dp1[i][j], dp2[i][j]);
            }
        }
        dp1 = new int[n][m];
        dp2 = new int[n][m];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j < m; j++) {
                if (grid[i + 1][j] == 1 && grid[i][j] == 1 && grid[i][j - 1] == 1) {
                    dp1[i][j] = 1 + Math.min(dp1[i + 1][j], dp1[i][j - 1]);
                }

            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (grid[i + 1][j] == 1 && grid[i][j] == 1 && grid[i][j + 1] == 1) {
                    dp2[i][j] = 1 + Math.min(dp2[i + 1][j], dp2[i][j + 1]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res += Math.min(dp1[i][j], dp2[i][j]);
            }
        }
        return res;
    }
}
