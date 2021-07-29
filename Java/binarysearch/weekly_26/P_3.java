package binarysearch.weekly_26;

public class P_3 {

    public int solve(String s) {
        int res = s.length();
        for (int i = 0; i < s.length(); i++) {
            res = Math.min(res, minDistance(s.substring(0, i), s.substring(i)));
        }
        return res;
    }

    public int minDistance(String word1, String word2) {
        final int n = word1.length();
        final int m = word2.length();
        final int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) { dp[i][0] = i; }
        for (int i = 1; i <= m; i++) { dp[0][i] = i; }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length()][m];
    }
}
