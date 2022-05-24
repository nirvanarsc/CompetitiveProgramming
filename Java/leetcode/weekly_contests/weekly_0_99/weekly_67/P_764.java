package leetcode.weekly_contests.weekly_0_99.weekly_67;

public class P_764 {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        final boolean[][] g = new boolean[n][n];
        for (int[] m : mines) {
            g[m[0]][m[1]] = true;
        }
        final int[][][] dp = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = 0; j < n; j++) {
                curr = g[i][j] ? 0 : curr + 1;
                dp[i][j][0] = curr;
            }
            curr = 0;
            for (int j = n - 1; j >= 0; j--) {
                curr = g[i][j] ? 0 : curr + 1;
                dp[i][j][1] = curr;
            }
        }
        for (int j = 0; j < n; j++) {
            int curr = 0;
            for (int i = 0; i < n; i++) {
                curr = g[i][j] ? 0 : curr + 1;
                dp[i][j][2] = curr;
            }
            curr = 0;
            for (int i = n - 1; i >= 0; i--) {
                curr = g[i][j] ? 0 : curr + 1;
                dp[i][j][3] = curr;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curr = (int) 1e9;
                for (int k = 0; k < 4; k++) {
                    curr = Math.min(curr, dp[i][j][k]);
                }
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}
