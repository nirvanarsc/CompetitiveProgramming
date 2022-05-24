package leetcode.weekly_contests.weekly_0_99.weekly_96;

public class P_883 {

    public int projectionArea(int[][] grid) {
        int res = 0;
        for (int[] row : grid) {
            int max = Integer.MIN_VALUE;
            for (int num : row) {
                max = Math.max(max, num);
                res += num > 0 ? 1 : 0;
            }
            res += max;
        }
        for (int col = 0; col < grid[0].length; col++) {
            int max = Integer.MIN_VALUE;
            for (int[] ints : grid) {
                max = Math.max(max, ints[col]);
            }
            res += max;
        }
        return res;
    }

    public int projectionAreaLee(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int maxRow = 0, maxCol = 0;
            for (int j = 0; j < grid.length; j++) {
                maxRow = Math.max(maxRow, grid[j][i]);
                maxCol = Math.max(maxCol, grid[i][j]);
                res += grid[i][j] > 0 ? 1 : 0;
            }
            res += maxRow;
            res += maxCol;
        }
        return res;
    }
}
