package leetcode.weekly_contests.weekly_200_299.weekly_226;

public class P_1745 {

    public boolean checkPartitioning(String s) {
        final int n = s.length();
        final boolean[][] dp = new boolean[n][n];
        for (int col = 0; col < n; col++) {
            for (int row = 0; row <= col; row++) {
                dp[row][col] = s.charAt(row) == s.charAt(col) && (col - row <= 2 || dp[row + 1][col - 1]);
            }
        }
        for (int i = 0; i < n - 2; i++) {
            if (dp[0][i]) {
                for (int j = i + 1; j < n - 1; j++) {
                    if (dp[i + 1][j] && dp[j + 1][n - 1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
