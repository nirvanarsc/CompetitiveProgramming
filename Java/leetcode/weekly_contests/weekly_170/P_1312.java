package leetcode.weekly_contests.weekly_170;

public class P_1312 {

    public int longestPalindromeSubseq(String s) {
        final int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[s.length() - 1][0];
    }

    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
}
