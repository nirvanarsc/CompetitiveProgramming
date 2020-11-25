package binarysearch.hard;

public class P_3 {

    public boolean solve(String pattern, String s) {
        final Boolean[][] dp = new Boolean[pattern.length() + 1][s.length() + 1];
        return dfs(pattern.toCharArray(), s.toCharArray(), 0, 0, dp);
    }

    private static boolean dfs(char[] p, char[] s, int i, int j, Boolean[][] dp) {
        if (i == p.length) {
            return j == s.length;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean res = false;
        final boolean first = j < s.length && (p[i] == s[j] || p[i] == '.');
        final boolean star = i < (p.length - 1) && p[i + 1] == '*';
        if (star) {
            res = dfs(p, s, i + 2, j, dp);
        }
        res |= first && dfs(p, s, i + (star ? 0 : 1), j + 1, dp);

        return dp[i][j] = res;
    }
}
