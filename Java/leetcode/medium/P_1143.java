package leetcode.medium;

public class P_1143 {

    public int longestCommonSubsequenceBottomUp(String text1, String text2) {
        final int n = text1.length();
        final int m = text2.length();
        final int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    static boolean[][] seen;
    static int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        final int n = text1.length();
        final int m = text2.length();
        seen = new boolean[n][m];
        dp = new int[n][m];
        return dfs(text1.toCharArray(), text2.toCharArray(), 0, 0);
    }

    private static int dfs(char[] l, char[] r, int i, int j) {
        if (i == l.length || j == r.length) {
            return 0;
        }
        if (seen[i][j]) {
            return dp[i][j];
        }
        int res = 0;
        res = Math.max(res, dfs(l, r, i + 1, j));
        res = Math.max(res, dfs(l, r, i, j + 1));
        if (l[i] == r[j]) {
            res = Math.max(res, 1 + dfs(l, r, i + 1, j + 1));
        }
        seen[i][j] = true;
        return dp[i][j] = res;
    }
}
