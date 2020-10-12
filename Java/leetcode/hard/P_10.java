package leetcode.hard;

public class P_10 {

    public boolean isMatch(String text, String pattern) {
        return dfs(0, 0, text, pattern, new Boolean[text.length() + 1][pattern.length() + 1]);
    }

    public boolean dfs(int i, int j, String text, String pattern, Boolean[][] dp) {
        if (j == pattern.length()) {
            return i == text.length();
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        final boolean ans;
        final boolean first_match = i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.');

        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            ans = dfs(i, j + 2, text, pattern, dp) || first_match && dfs(i + 1, j, text, pattern, dp);
        } else {
            ans = first_match && dfs(i + 1, j + 1, text, pattern, dp);
        }

        return dp[i][j] = ans;
    }
}
