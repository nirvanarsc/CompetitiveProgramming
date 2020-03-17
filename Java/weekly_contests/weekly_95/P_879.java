package weekly_contests.weekly_95;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_879 {

    private static final int MOD = (int) (1e9 + 7);

    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        return dfs(0, G, P, group, profit, new Integer[profit.length][G + 1][P + 1]);
    }

    private static int dfs(int idx, int G, int P, int[] group, int[] profit, Integer[][][] dp) {
        if (idx == group.length) {
            return P <= 0 ? 1 : 0;
        }
        final int actP = Math.max(P, 0);
        if (dp[idx][G][actP] != null) {
            return dp[idx][G][actP];
        }
        int res = 0;
        if (G >= group[idx]) {
            res = (res + dfs(idx + 1, G - group[idx], P - profit[idx], group, profit, dp)) % MOD;
        }
        res = (res + dfs(idx + 1, G, P, group, profit, dp)) % MOD;
        return dp[idx][G][actP] = res;
    }
}
