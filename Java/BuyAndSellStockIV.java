import java.util.Arrays;

public class BuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        final int m = prices.length;
        if (m == 0 || m == 1 || k == 0) {
            return 0;
        }
        if (k > m / 2) {
            int ans = 0;
            for (int i = 1; i < m; ++i) {
                ans += Math.max(0, prices[i] - prices[i - 1]);
            }
            return ans;
        }
        final int[] buy = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        final int[] profit = new int[k];

        for (int i : prices) {
            buy[0] = Math.min(buy[0], i);
            profit[0] = Math.max(profit[0], i - buy[0]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.min(buy[j], i - profit[j - 1]);
                profit[j] = Math.max(profit[j], i - buy[j]);
            }
        }

        return profit[k - 1];
    }
}
