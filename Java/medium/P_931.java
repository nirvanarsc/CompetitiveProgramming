package medium;

public class P_931 {

    public int minFallingPathSum(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] += getMin(i, j, grid);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < grid[0].length; j++) {
            res = Math.min(res, grid[grid.length - 1][j]);
        }
        return res;
    }

    private static int getMin(int i, int j, int[][] grid) {
        int res = Integer.MAX_VALUE;
        for (int t : new int[] { -1, 0, 1 }) {
            if (t + j >= 0 && t + j < grid[0].length) {
                res = Math.min(res, grid[i - 1][t + j]);
            }
        }
        return res;
    }
}
