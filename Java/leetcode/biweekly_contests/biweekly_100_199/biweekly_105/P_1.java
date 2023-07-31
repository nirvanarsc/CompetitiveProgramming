package leetcode.biweekly_contests.biweekly_100_199.biweekly_105;

import java.util.Arrays;

public class P_1 {

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        final int u = prices[0] + prices[1];
        return u <= money ? (money - u) : money;
    }
}
