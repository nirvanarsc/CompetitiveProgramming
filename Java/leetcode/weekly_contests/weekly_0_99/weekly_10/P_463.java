package leetcode.weekly_contests.weekly_0_99.weekly_10;

public class P_463 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        final int n = grid.length;
        final int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : DIRS) {
                        final int nx = i + dir[0];
                        final int ny = j + dir[1];
                        final boolean inBounds = 0 <= nx && nx < n && 0 <= ny && ny < m;
                        if (!inBounds || grid[nx][ny] == 0) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
