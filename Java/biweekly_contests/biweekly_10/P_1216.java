package biweekly_contests.biweekly_10;

public class P_1216 {

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

    public boolean isValidPalindrome(String s, int k) {
        return s.length() - longestPalindromeSubseq(s) <= k;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        final int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public boolean isValidPalindromeLCS(String s, int k) {
        final String reverse = new StringBuilder(s).reverse().toString();
        return s.length() - longestCommonSubsequence(s, reverse) <= k;
    }
}
