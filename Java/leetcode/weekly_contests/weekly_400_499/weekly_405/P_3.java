package leetcode.weekly_contests.weekly_400_499.weekly_405;

public class P_3 {

    public int numberOfSubmatrices(char[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] x = new int[n + 1][m + 1];
        final int[][] y = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[i + 1][j + 1] = (grid[i][j] == 'X' ? 1 : 0) + x[i + 1][j] + x[i][j + 1] - x[i][j];
                y[i + 1][j + 1] = (grid[i][j] == 'Y' ? 1 : 0) + y[i + 1][j] + y[i][j + 1] - y[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                final int xx = sumRegion(0, 0, i, j, x);
                final int yy = sumRegion(0, 0, i, j, y);
                if (xx > 0 && xx == yy) {
                    res++;
                }
            }
        }
        return res;
    }

    public static int sumRegion(int row1, int col1, int row2, int col2, int[][] dp) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}
