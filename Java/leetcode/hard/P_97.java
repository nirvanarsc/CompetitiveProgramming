package leetcode.hard;

public class P_97 {

    static int n;
    static int m;
    static int[][] dp;
    static boolean[][] seen;

    public boolean isInterleave(String s1, String s2, String s3) {
        n = s1.length();
        m = s2.length();
        if (s3.length() != n + m) {
            return false;
        }
        dp = new int[n + 1][m + 1];
        seen = new boolean[n + 1][m + 1];
        return dfs(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0) > 0;
    }

    private static int dfs(char[] l, char[] r, char[] w, int i, int j) {
        if (i + j == w.length) {
            return 1;
        }
        if (seen[i][j]) {
            return dp[i][j];
        }
        int res = 0;
        if (i < l.length && l[i] == w[i + j]) {
            res = Math.max(res, dfs(l, r, w, i + 1, j));
        }
        if (j < r.length && r[j] == w[i + j]) {
            res = Math.max(res, dfs(l, r, w, i, j + 1));
        }
        seen[i][j] = true;
        return dp[i][j] = res;
    }
}
