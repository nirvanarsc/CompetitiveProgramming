package leetcode.easy;

public class P_121 {

    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            buy = Math.min(buy, price);
            profit = Math.max(profit, price - buy);
        }
        return profit;
    }

    public int maxProfitSpace(int[] prices) {
        final int[] max = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            max[i] = Math.max(prices[i], i == prices.length - 1 ? 0 : max[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, max[i] - prices[i]);
        }
        return res;
    }

    public int maxProfitKadane(int[] prices) {
        int curr = 0, res = 0;
        for (int i = 1; i < prices.length; i++) {
            curr = Math.max(0, curr + (prices[i] - prices[i - 1]));
            res = Math.max(curr, res);
        }
        return res;
    }
}
