package leetcode.medium;

import java.util.Arrays;

public class P_322 {

    public int coinChange(int[] coins, int amount) {
        final int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChangeTopDown(int[] coins, int amount) {
        final Integer[][] dp = new Integer[coins.length][amount + 1];
        final int res = helper(coins, amount, dp, 0);
        return res == (int) 1e9 ? -1 : res;
    }

    private static int helper(int[] coins, int amount, Integer[][] dp, int start) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || start == coins.length) {
            return (int) 1e9;
        }

        if (dp[start][amount] != null) {
            return dp[start][amount];
        }

        final int with = 1 + helper(coins, amount - coins[start], dp, start);
        final int without = helper(coins, amount, dp, start + 1);

        return dp[start][amount] = Math.min(with, without);
    }
}
