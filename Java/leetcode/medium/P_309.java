package leetcode.medium;

public class P_309 {

    public int maxProfit(int[] prices) {
        int sell = Integer.MIN_VALUE;
        int hold = Integer.MIN_VALUE;
        int reset = 0;
        for (int price : prices) {
            final int preSell = sell;
            sell = hold + price;
            hold = Math.max(hold, reset - price);
            reset = Math.max(reset, preSell);
        }
        return Math.max(sell, reset);
    }

    public int maxProfitTopDown(int[] prices) {
        return dfs(prices, 0, new Integer[prices.length]);
    }

    private static int dfs(int[] prices, int start, Integer[] dp) {
        if (start >= prices.length) {
            return 0;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        int res = dfs(prices, start + 1, dp);
        for (int i = start + 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - prices[start] + dfs(prices, i + 2, dp));
        }
        return dp[start] = res;
    }
}
