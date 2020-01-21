package medium;

public class P_1219 {

    public int getMaximumGold(int[][] grid) {
        final int[] res = { Integer.MIN_VALUE };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    recurse(i, j, 0, grid, res);
                }
            }
        }
        return res[0];
    }

    private static void recurse(int i, int j, int curr, int[][] grid, int[] res) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] <= 0) {
            res[0] = Math.max(res[0], curr);
            return;
        }

        grid[i][j] = -grid[i][j];
        for (int[] dir : new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }) {
            recurse(i + dir[0], j + dir[1], curr - grid[i][j], grid, res);
        }
        grid[i][j] = -grid[i][j];
    }
}
