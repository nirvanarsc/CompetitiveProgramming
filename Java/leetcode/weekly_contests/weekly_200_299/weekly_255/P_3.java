package leetcode.weekly_contests.weekly_200_299.weekly_255;

public class P_3 {

    static boolean[][] seen;
    static int[][] dp;

    public int minimizeTheDifference(int[][] mat, int target) {
        final int n = mat.length;
        seen = new boolean[70 * n + 1][n];
        dp = new int[70 * n + 1][n];
        return dfs(mat, target, 0, 0);
    }

    private static int dfs(int[][] mat, int target, int sum, int row) {
        if (row == mat.length) {
            return Math.abs(sum - target);
        }
        if (seen[sum][row]) {
            return dp[sum][row];
        }
        int res = (int) 1e9;
        for (int i = 0; i < mat[row].length; i++) {
            res = Math.min(res, dfs(mat, target, sum + mat[row][i], row + 1));
        }
        seen[sum][row] = true;
        return dp[sum][row] = res;
    }
}
