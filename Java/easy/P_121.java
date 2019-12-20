package easy;

public class P_121 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int curr = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            curr = Math.min(curr, prices[i]);
            max = Math.max(max, prices[i] - curr);
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for (int i : prices) {
            buy = Math.min(buy, i);
            profit = Math.max(profit, i - buy);
        }
        return profit;
    }

    public int maxProfit3(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur + (prices[i] - prices[i - 1]));
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
