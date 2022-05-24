package leetcode.weekly_contests.weekly_0_99.weekly_42;

public class P_647 {

    public int countSubstrings(String s) {
        final int n = s.length();
        final boolean[][] dp = new boolean[n][n];
        int res = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
