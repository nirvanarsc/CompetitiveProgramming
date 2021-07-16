package binarysearch.weekly_27;

public class P_3 {

    static boolean[] seen;
    static int[] dp;

    public int solve(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            seen = new boolean[m];
            dp = new int[m];
            r[i] = dfs(matrix[i], 0);
        }
        seen = new boolean[n];
        dp = new int[n];
        return dfs(r, 0);
    }

    private static int dfs(int[] row, int idx) {
        if (idx >= row.length) {
            return 0;
        }
        if (seen[idx]) {
            return dp[idx];
        }
        int res = 0;
        res = Math.max(res, dfs(row, idx + 1));
        res = Math.max(res, row[idx] + dfs(row, idx + 2));
        seen[idx] = true;
        return dp[idx] = res;
    }
}
