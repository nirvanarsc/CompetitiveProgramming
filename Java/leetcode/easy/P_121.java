package leetcode.easy;

public class P_121 {

    public int maxProfit(int[] prices) {
        int buy = (int) 1e9;
        int res = 0;
        for (int price : prices) {
            buy = Math.min(buy, price);
            res = Math.max(res, price - buy);
        }
        return res;
    }
}
