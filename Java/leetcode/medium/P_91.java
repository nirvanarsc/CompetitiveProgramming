package leetcode.medium;

public class P_91 {

    static int[] dp;
    static boolean[] seen;
    static int n;

    public int numDecodings(String s) {
        n = s.length();
        dp = new int[n];
        seen = new boolean[n];
        return dfs(s.toCharArray(), 0);
    }

    private static int dfs(char[] s, int idx) {
        if (idx == n) {
            return 1;
        }
        if (seen[idx]) {
            return dp[idx];
        }
        int res = 0;
        if (s[idx] > '0') {
            res += dfs(s, idx + 1);
        }
        if (idx < n - 1) {
            if (s[idx] == '2' && s[idx + 1] <= '6') {
                res += dfs(s, idx + 2);
            }
            if (s[idx] == '1') {
                res += dfs(s, idx + 2);
            }
        }
        seen[idx] = true;
        return dp[idx] = res;
    }
}
