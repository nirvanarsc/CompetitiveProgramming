package weekly_contests.weekly_55;

public class P_714 {

    public int maxProfit(int[] prices, int fee) {
        int res = 0, curr = -(int) 1e9;

        for (int price : prices) {
            res = Math.max(res, curr + price - fee);
            curr = Math.max(curr, res - price);
        }

        return res;
    }
}
