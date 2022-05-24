package leetcode.weekly_contests.weekly_0_99.weekly_32;

public class P_583 {

    public int minDistance(String word1, String word2) {
        final int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        final int lcs = dp[word1.length()][word2.length()];
        return word1.length() - lcs + word2.length() - lcs;
    }
}
