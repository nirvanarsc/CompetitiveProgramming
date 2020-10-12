package leetcode.weekly_contests.weekly_46;

public class P_664 {

    public int strangePrinter(String s) {
        final int n = s.length();
        return helper(s, 0, n - 1, new Integer[n][n]);
    }

    private static int helper(String s, int i, int j, Integer[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int res = 1 + helper(s, i + 1, j, dp);
        for (int m = i + 1; m <= j; m++) {
            if (s.charAt(m) == s.charAt(i)) {
                res = Math.min(res, helper(s, i + 1, m - 1, dp) + helper(s, m, j, dp));
            }
        }
        return dp[i][j] = res;
    }
}
