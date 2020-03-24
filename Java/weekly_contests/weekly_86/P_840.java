package weekly_contests.weekly_86;

public class P_840 {

    public int numMagicSquaresInside(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (isMagic(grid, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean isMagic(int[][] grid, int row, int col) {
        if (grid[row + 1][col + 1] != 5) {
            return false;
        }
        final boolean[] record = new boolean[10];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || record[grid[i][j]]) {
                    return false;
                }
                record[grid[i][j]] = true;
            }
        }
        final int sum1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        final int sum2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        if (sum1 != 15 || sum2 != 15) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != 15) {
                return false;
            }
            if (grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i] != 15) {
                return false;
            }
        }
        return true;
    }
}
