package weekly_contests.weekly_10;

public class P_463 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += getP(grid, i, j);
                }
            }
        }
        return res;
    }

    private static int getP(int[][] grid, int r, int c) {
        int res = 0;
        for (int[] dir : DIRS) {
            final int nx = r + dir[0];
            final int ny = c + dir[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                res += grid[nx][ny] == 0 ? 1 : 0;
            } else {
                res++;
            }
        }
        return res;
    }
}
