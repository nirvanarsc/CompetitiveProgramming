package easy;

public class P_121 {

    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for (int i : prices) {
            buy = Math.min(buy, i);
            profit = Math.max(profit, i - buy);
        }
        return profit;
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
