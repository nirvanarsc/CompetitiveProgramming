package leetcode.weekly_contests.weekly_200_299.weekly_237;

import java.util.Arrays;

public class P_1833 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        final int n = costs.length;
        for (int i = 0; i < n; i++) {
            if (coins < costs[i]) {
                return i;
            }
            coins -= costs[i];
        }
        return n;
    }
}
