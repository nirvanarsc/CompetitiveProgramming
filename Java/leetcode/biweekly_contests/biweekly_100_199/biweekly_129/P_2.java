package leetcode.biweekly_contests.biweekly_100_199.biweekly_129;

public class P_2 {

    public long numberOfRightTriangles(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final long[] row = new long[n];
        final long[] col = new long[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    res += (row[i] - 1) * (col[j] - 1);
                }
            }
        }
        return res;
    }
}
