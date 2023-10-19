package leetcode.weekly_contests.weekly_300_399.weekly_367;

public class P_4 {

    private static final int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] pre = new int[n][m];
        final int[][] suff = new int[n][m];
        final int[][] res = new int[n][m];
        int curr = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pre[i][j] = curr;
                curr = (curr * (grid[i][j] % MOD)) % MOD;
            }
        }
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                suff[i][j] = curr;
                curr = (curr * (grid[i][j] % MOD)) % MOD;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = (pre[i][j] * suff[i][j]) % MOD;
            }
        }
        return res;
    }
}
