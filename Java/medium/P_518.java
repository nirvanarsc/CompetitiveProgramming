package medium;

import java.util.Arrays;

public class P_518 {

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        return dfs(amount, coins, coins.length - 1, new Integer[amount + 1][coins.length]);
    }

    private static int dfs(int amt, int[] coins, int idx, Integer[][] dp) {
        if (idx == -1) {
            return amt == 0 ? 1 : 0;
        }
        if (dp[amt][idx] != null) {
            return dp[amt][idx];
        }
        int take = 0;
        if (amt >= coins[idx]) {
            take = dfs(amt - coins[idx], coins, idx, dp);
        }
        final int skip = dfs(amt, coins, idx - 1, dp);
        return dp[amt][idx] = skip + take;
    }

    public int changeBottomUp(int amount, int[] coins) {
        final int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }
}
