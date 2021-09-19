package leetcode.hard;

public class P_115 {

    static boolean[][] seen;
    static int[][] dp;

    public int numDistinct(String s, String t) {
        final int n = s.length();
        final int m = t.length();
        seen = new boolean[n][m];
        dp = new int[n][m];
        return dfs(s.toCharArray(), t.toCharArray(), 0, 0);
    }

    private static int dfs(char[] s, char[] t, int i, int j) {
        if (j == t.length) {
            return 1;
        }
        if (i == s.length) {
            return 0;
        }
        if (seen[i][j]) {
            return dp[i][j];
        }
        int res = 0;
        if (s[i] == t[j]) {
            res += dfs(s, t, i + 1, j + 1);
        }
        res += dfs(s, t, i + 1, j);
        seen[i][j] = true;
        return dp[i][j] = res;
    }
}
