package leetcode.medium;

public class P_516 {

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

    public int longestPalindromeSpace(String s) {
        final char[] c = s.toCharArray();
        final int[] dp = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            dp[i] = 1;
            int maxSoFar = 0;
            for (int j = i - 1; j >= 0; j--) {
                final int prev = dp[j];
                if (c[i] == c[j]) {
                    dp[j] = maxSoFar + 2;
                }
                maxSoFar = Math.max(prev, maxSoFar);
            }
        }
        int max = 0;
        for (int i : dp) { max = Math.max(max, i); }
        return max;
    }

    public int longestPalindromeSubseqLCS(String s) {
        final String reverse = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s, reverse);
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
}
