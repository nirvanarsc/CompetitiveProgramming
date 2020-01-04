package medium;

public class P_309 {

    public int maxProfitBottomUp(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;

        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }

    public int maxProfit(int[] prices) {
        return recurse(prices, 0, new Integer[prices.length]);
    }

    private static int recurse(int[] prices, int start, Integer[] dp) {
        if (start >= prices.length - 1) {
            return 0;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        final int skip = recurse(prices, start + 1, dp);
        int trade = Integer.MIN_VALUE;
        for (int i = start + 1; i < prices.length; i++) {
            trade = Math.max(trade, prices[i] - prices[start] + recurse(prices, i + 2, dp));
        }

        return dp[start] = Math.max(skip, trade);
    }
}
