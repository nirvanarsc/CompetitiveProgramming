package weekly_contests.weekly_63;

public class P_750 {

    public int countCornerRectangles(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        int res = 0;
        for (int r = 0; r < n; r++) {
            for (int rk = r + 1; rk < n; rk++) {
                int curr = 0;
                for (int c = 0; c < m; c++) {
                    if (grid[r][c] == 1 && grid[rk][c] == 1) {
                        curr++;
                    }
                }
                res += (curr * (curr - 1)) / 2;
            }
        }
        return res;
    }

    public int countCornerRectanglesDP(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] dp = new int[n][m];
        int res = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < m; j++) {
                if (ints[j] == 1) {
                    for (int q = j + 1; q < m; q++) {
                        if (ints[q] == 1) {
                            res += dp[j][q]++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
