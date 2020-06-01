package hard;

public class P_115 {

    public int numDistinct(String s, String t) {
        return dfs(s, t, 0, 0, new Integer[s.length()][t.length()]);
    }

    private static int dfs(String s, String t, int i, int j, Integer[][] dp) {
        if (i == s.length() || j == t.length()) {
            return j == t.length() ? 1 : 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int res = dfs(s, t, i + 1, j, dp);
        if (s.charAt(i) == t.charAt(j)) {
            res += dfs(s, t, i + 1, j + 1, dp);
        }
        return dp[i][j] = res;
    }
}
