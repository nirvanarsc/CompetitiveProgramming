package leetcode.weekly_contests.weekly_237;

import java.util.Arrays;

public class P_1833 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        for (int i = 0; i < costs.length; i++) {
            if (coins < costs[i]) {
                return i;
            }
            coins -= costs[i];
        }
        return costs.length;
    }
}
