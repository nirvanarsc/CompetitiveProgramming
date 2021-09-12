package leetcode.weekly_contests.weekly_258;

public class P_3 {

    public int maxProduct(String s) {
        final int n = s.length();
        int res = 0;
        for (int mask = 0; mask < 1 << n; mask++) {
            final StringBuilder ll = new StringBuilder();
            final StringBuilder rr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    ll.append(s.charAt(i));
                } else {
                    rr.append(s.charAt(i));
                }
            }
            final String l = ll.toString();
            final String r = rr.toString();
            res = Math.max(res, longestPalindromeSubseq(l) * longestPalindromeSubseq(r));
        }
        return res;
    }

    public static int longestPalindromeSubseq(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        final int n = s.length();
        final int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n - 1][0];
    }
}
