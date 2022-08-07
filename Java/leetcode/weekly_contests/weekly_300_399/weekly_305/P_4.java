package leetcode.weekly_contests.weekly_300_399.weekly_305;

public class P_4 {

    public int longestIdealString(String s, int k) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        final int[][] dp = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (Math.abs(w[i] - 'a' - j) <= k) {
                    dp[i + 1][w[i] - 'a'] = Math.max(dp[i + 1][w[i] - 'a'], dp[i][j] + 1);
                }
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = Math.max(res, dp[n][i]);
        }
        return res;
    }
}
