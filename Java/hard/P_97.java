package hard;

public class P_97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        return dfs(s1, s2, 0, 0, s3, new Boolean[s1.length()][s2.length()]);
    }

    private static boolean dfs(String s1, String s2, int i, int j, String s3, Boolean[][] dp) {
        if (i == s1.length()) { return s2.substring(j).equals(s3.substring(i + j)); }
        if (j == s2.length()) { return s1.substring(i).equals(s3.substring(i + j)); }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean res = false;
        if (s1.charAt(i) == s3.charAt(i + j)) {
            res = dfs(s1, s2, i + 1, j, s3, dp);
        }
        if (s2.charAt(j) == s3.charAt(i + j)) {
            res |= dfs(s1, s2, i, j + 1, s3, dp);
        }
        return dp[i][j] = res;
    }
}
