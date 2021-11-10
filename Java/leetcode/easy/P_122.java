package leetcode.easy;

public class P_122 {

    public int maxProfit(int[] prices) {
        final int n = prices.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < (n - 1) && prices[j] >= prices[j + 1]) {
                j++;
            }
            final int buy = prices[j];
            while (j < (n - 1) && prices[j] <= prices[j + 1]) {
                j++;
            }
            res += prices[j] - buy;
            i = j;
        }
        return res;
    }
}
