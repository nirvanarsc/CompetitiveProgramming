package weekly_contests.weekly_110;

public class P_940 {

    private static final int MOD = (int) (1e9 + 7);

    @SuppressWarnings("MethodParameterNamingConvention")
    public int distinctSubseqII(String S) {
        final Integer[] dp = new Integer[S.length()];
        dfs(S, 0, dp);
        int res = 0;
        for (int num : dp) {
            res = (res + num) % MOD;
        }
        return res;
    }

    private static int dfs(String s, int i, Integer[] dp) {
        if (i == s.length()) {
            return 1;
        }
        if (dp[i] != null) {
            return dp[i];
        }

        int res = 0;
        boolean dup = false;
        for (int k = i + 1; k < s.length(); k++) {
            res = (res + dfs(s, k, dp)) % MOD;
            if (s.charAt(k) == s.charAt(i)) {
                dup = true;
                break;
            }
        }

        return dp[i] = dup ? res : res + 1;
    }
}
