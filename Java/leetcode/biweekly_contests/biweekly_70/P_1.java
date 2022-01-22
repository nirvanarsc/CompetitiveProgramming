package leetcode.biweekly_contests.biweekly_70;

import java.util.Arrays;

public class P_1 {

    public int minimumCost(int[] cost) {
        final int n = cost.length;
        Arrays.sort(cost);
        int res = 0;
        for (int c : cost) {
            res += c;
        }
        final int d = n / 3;
        for (int i = 0, j = n - 3; i < d; i++, j -= 3) {
            res -= cost[j];
        }
        return res;
    }
}
