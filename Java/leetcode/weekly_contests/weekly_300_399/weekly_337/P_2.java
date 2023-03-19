package leetcode.weekly_contests.weekly_300_399.weekly_337;

public class P_2 {

    public boolean checkValidGrid(int[][] grid) {
        final int n = grid.length;
        final int[] x = new int[n * n];
        final int[] y = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x[grid[i][j]] = i;
                y[grid[i][j]] = j;
            }
        }
        if (!(x[0] == 0 && y[0] == 0)) {
            return false;
        }
        for (int i = 1; i < n * n; i++) {
            final int dx = Math.abs(x[i] - x[i - 1]);
            final int dy = Math.abs(y[i] - y[i - 1]);
            if (!(dx == 2 && dy == 1) && !(dx == 1 && dy == 2)) {
                return false;
            }
        }
        return true;
    }
}
