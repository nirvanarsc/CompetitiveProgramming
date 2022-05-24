package leetcode.weekly_contests.weekly_200_299.weekly_246;

public class P_3 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        final int n = grid1.length;
        final int m = grid1[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    final int[] curr = { 1 };
                    dfs(grid1, grid2, i, j, n, m, curr);
                    if (curr[0] == 1) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] g1, int[][] g2, int r, int c, int n, int m, int[] res) {
        res[0] &= g1[r][c];
        g2[r][c] = 0;
        for (int[] dir : DIRS) {
            final int nr = r + dir[0];
            final int nc = c + dir[1];
            if (0 <= nr && nr < n && 0 <= nc && nc < m && g2[nr][nc] == 1) {
                dfs(g1, g2, nr, nc, n, m, res);
            }
        }
    }
}
