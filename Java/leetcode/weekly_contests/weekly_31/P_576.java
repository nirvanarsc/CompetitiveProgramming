package leetcode.weekly_contests.weekly_31;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_576 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private static final int MOD = (int) (1e9 + 7);

    public int findPaths(int m, int n, int N, int i, int j) {
        if (N == 0) {
            return 0;
        }
        final int[][] grid = new int[m][n];
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                int res = 0;
                for (int[] dir : DIRS) {
                    final int nx = k + dir[0];
                    final int ny = l + dir[1];
                    if (nx < 0 || nx == m || ny < 0 || ny == n) {
                        res++;
                    }
                }
                grid[k][l] = res;
            }
        }
        return grid[i][j] + recurse(grid, N - 1, i, j, new Integer[m][n][N]);
    }

    private static int recurse(int[][] grid, int N, int i, int j, Integer[][][] dp) {
        if (N == 0) {
            return 0;
        }
        if (dp[i][j][N] != null) {
            return dp[i][j][N];
        }
        int res = 0;
        for (int[] dir : DIRS) {
            final int nx = i + dir[0];
            final int ny = j + dir[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                res = (res + grid[nx][ny] + recurse(grid, N - 1, nx, ny, dp)) % MOD;
            }
        }
        return dp[i][j][N] = res;
    }
}
