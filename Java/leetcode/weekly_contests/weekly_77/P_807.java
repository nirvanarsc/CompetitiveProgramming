package leetcode.weekly_contests.weekly_77;

public class P_807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[] maxCols = new int[m];
        final int[] maxRows = new int[n];
        int res = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                maxRows[row] = Math.max(maxRows[row], grid[row][col]);
                maxCols[col] = Math.max(maxCols[col], grid[row][col]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res += Math.min(maxRows[i], maxCols[j]) - grid[i][j];
            }
        }
        return res;
    }
}
