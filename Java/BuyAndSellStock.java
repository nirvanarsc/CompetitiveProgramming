public class BuyAndSellStock {

    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for (int i : prices) {
            buy = Math.min(buy, i);
            profit = Math.max(profit, i - buy);
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur + (prices[i] - prices[i - 1]));
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
