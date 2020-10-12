package leetcode.weekly_contests.weekly_101;

public class P_903 {

    private static final int MOD = (int) (1e9 + 7);

    @SuppressWarnings("MethodParameterNamingConvention")
    public int numPermsDISequence(String S) {
        int res = 0;
        final int n = S.length() + 1;
        final boolean[] used = new boolean[n];
        final Integer[][] dp = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            used[i] = true;
            res = (res + recurse(S, 0, i, used, dp)) % MOD;
            used[i] = false;
        }
        return res;
    }

    private static int recurse(String s, int i, int prev, boolean[] used, Integer[][] dp) {
        if (i == s.length()) {
            return 1;
        }
        if (dp[i][prev] != null) {
            return dp[i][prev];
        }

        int res = 0;
        for (int k = 0; k < s.length() + 1; k++) {
            if (!used[k]) {
                if ((s.charAt(i) == 'D' && k < prev) || (s.charAt(i) == 'I' && k > prev)) {
                    used[k] = true;
                    res = (res + recurse(s, i + 1, k, used, dp)) % MOD;
                    used[k] = false;
                }
            }
        }
        return dp[i][prev] = res;
    }
}
