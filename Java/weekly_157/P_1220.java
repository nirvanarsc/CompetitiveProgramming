package weekly_157;

public class P_1220 {

    private static final int MOD = (int) (1e9 + 7);

    public int countVowelPermutation(int n) {
        final int[][] g = { { 1 }, { 0, 2 }, { 0, 1, 3, 4 }, { 2, 4 }, { 0 } };
        final Integer[][] dp = new Integer[n][5];
        int res = 0;
        for (int i = 0; i < g.length; i++) {
            res = (res + recurse(g, n - 1, i, dp)) % MOD;
        }
        return res;
    }

    private static int recurse(int[][] g, int n, int i, Integer[][] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n][i] != null) {
            return dp[n][i];
        }
        int res = 0;
        for (int next : g[i]) {
            res = (res + recurse(g, n - 1, next, dp)) % MOD;
        }
        return dp[n][i] = res;
    }
}
