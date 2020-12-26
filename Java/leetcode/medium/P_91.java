package leetcode.medium;

public class P_91 {

    public int numDecodings(String s) {
        return dfs(s.toCharArray(), 0, new Integer[s.length()]);
    }

    private static int dfs(char[] s, int idx, Integer[] dp) {
        if (idx == s.length) {
            return 1;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        int res = 0;
        if (s[idx] > '0') {
            res += dfs(s, idx + 1, dp);
        }
        if (idx < s.length - 1) {
            if (s[idx] == '2' && s[idx + 1] <= '6') {
                res += dfs(s, idx + 2, dp);
            }
            if (s[idx] == '1') {
                res += dfs(s, idx + 2, dp);
            }
        }
        return dp[idx] = res;
    }
}
