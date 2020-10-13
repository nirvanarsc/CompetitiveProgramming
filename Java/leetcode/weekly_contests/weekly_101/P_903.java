package leetcode.weekly_contests.weekly_101;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_903 {

    private static final int MOD = (int) (1e9 + 7);

    public int numPermsDISequence(String S) {
        final int n = S.length() + 1;
        return dfs(S, -1, -1, new boolean[n], new Integer[n][n]);
    }

    private static int dfs(String s, int i, int prev, boolean[] used, Integer[][] dp) {
        if (i == s.length()) {
            return 1;
        }
        if (prev != -1 && dp[i][prev] != null) {
            return dp[i][prev];
        }
        int res = 0;
        for (int k = 0; k < s.length() + 1; k++) {
            if (!used[k]) {
                if (prev == -1 || (s.charAt(i) == 'D' && k < prev) || (s.charAt(i) == 'I' && k > prev)) {
                    used[k] = true;
                    res = (res + dfs(s, i + 1, k, used, dp)) % MOD;
                    used[k] = false;
                }
            }
        }
        if (prev != -1) {
            dp[i][prev] = res;
        }
        return res;
    }
}
