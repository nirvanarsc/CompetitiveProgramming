package leetcode.weekly_contests.weekly_157;

public class P_1219 {

    public int getMaximumGoldInPlace(int[][] grid) {
        final int[] res = { 0 };
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

    public int getMaximumGold(int[][] grid) {
        final int[] res = { 0 };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    recurse(grid, i, j, 0, res, new boolean[grid.length][grid[0].length]);
                }
            }
        }
        return res[0];
    }

    private static void recurse(int[][] grid, int r, int c, int gold, int[] res, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] || grid[r][c] == 0) {
            return;
        }
        gold += grid[r][c];
        res[0] = Math.max(res[0], gold);
        visited[r][c] = true;
        for (int[] dir : new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }) {
            recurse(grid, r + dir[0], c + dir[1], gold, res, visited);
        }
        visited[r][c] = false;
    }
}
