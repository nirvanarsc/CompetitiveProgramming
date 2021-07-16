package leetcode.hard;

import java.util.Arrays;

public class P_188 {

    public int maxProfitBottomUp(int k, int[] prices) {
        final int n = prices.length;
        if (k == 0) {
            return 0;
        }
        if (k >= n / 2) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }
        final int[] buy = new int[k];
        final int[] profit = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        for (int price : prices) {
            buy[0] = Math.min(buy[0], price);
            profit[0] = Math.max(profit[0], price - buy[0]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.min(buy[j], price - profit[j - 1]);
                profit[j] = Math.max(profit[j], price - buy[j]);
            }
        }
        return profit[k - 1];
    }

    static boolean[][][] seen;
    static int[][][] dp;

    public int maxProfit(int k, int[] prices) {
        final int n = prices.length;
        seen = new boolean[n][2][k + 1];
        dp = new int[n][2][k + 1];
        return dfs(prices, 0, 0, k);
    }

    private static int dfs(int[] arr, int idx, int hasStock, int k) {
        if (idx == arr.length || k == 0) {
            return hasStock == 0 ? 0 : (int) -1e9;
        }
        if (seen[idx][hasStock][k]) {
            return dp[idx][hasStock][k];
        }
        int res = (int) -1e9;
        if (hasStock == 0) {
            res = Math.max(res, dfs(arr, idx + 1, 0, k));
            res = Math.max(res, -arr[idx] + dfs(arr, idx + 1, 1, k));
        } else {
            res = Math.max(res, dfs(arr, idx + 1, 1, k));
            res = Math.max(res, arr[idx] + dfs(arr, idx + 1, 0, k - 1));
        }
        seen[idx][hasStock][k] = true;
        return dp[idx][hasStock][k] = res;
    }
}
