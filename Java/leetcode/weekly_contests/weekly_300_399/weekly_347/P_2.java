package leetcode.weekly_contests.weekly_300_399.weekly_347;

public class P_2 {

    public int[][] differenceOfDistinctValues(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] res = new int[n][m];
        final int[] up = { -1, -1 };
        final int[] down = { 1, 1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = Math.abs(
                        f(i - 1, j - 1, n, m, grid, up) -
                        f(i + 1, j + 1, n, m, grid, down));
            }
        }
        return res;
    }

    private static int f(int i, int j, int n, int m, int[][] grid, int[] dir) {
        long seen = 0;
        while (0 <= i && i < n && 0 <= j && j < m) {
            seen |= 1L << grid[i][j];
            i += dir[0];
            j += dir[1];
        }
        return Long.bitCount(seen);
    }
}
