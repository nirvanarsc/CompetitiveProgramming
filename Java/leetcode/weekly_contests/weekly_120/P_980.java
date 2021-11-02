package leetcode.weekly_contests.weekly_120;

public class P_980 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    static int n;
    static int m;
    static int total;
    static int[][] g;
    static int[][] idx;
    static boolean[][][] seen;
    static int[][][] dp;

    public int uniquePathsIII(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        total = 0;
        g = grid;
        idx = new int[n][m];
        int sx = -1;
        int sy = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 0) {
                    idx[i][j] = total++;
                }
            }
        }
        seen = new boolean[n][m][1 << total];
        dp = new int[n][m][1 << total];
        return dfs(sx, sy, 0);
    }

    private static int dfs(int x, int y, int mask) {
        if (g[x][y] == 2) {
            return mask == (1 << total) - 1 ? 1 : 0;
        }
        if (g[x][y] == -1) {
            return 0;
        }
        if (seen[x][y][mask]) {
            return dp[x][y][mask];
        }
        int res = 0;
        for (int[] dir : DIRS) {
            final int nx = x + dir[0];
            final int ny = y + dir[1];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (g[nx][ny] == 2) {
                    res += dfs(nx, ny, mask);
                }
                if (g[nx][ny] == 0 && (mask & (1 << idx[nx][ny])) == 0) {
                    res += dfs(nx, ny, mask | (1 << idx[nx][ny]));
                }
            }
        }
        seen[x][y][mask] = true;
        return dp[x][y][mask] = res;
    }
}
