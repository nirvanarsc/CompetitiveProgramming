package hard;

public class P_123 {

    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;
        for (int i : prices) {
            buy1 = Math.min(buy1, i);
            profit1 = Math.max(profit1, i - buy1);
            buy2 = Math.min(buy2, i - profit1);
            profit2 = Math.max(profit2, i - buy2);
        }
        return profit2;
    }
}
