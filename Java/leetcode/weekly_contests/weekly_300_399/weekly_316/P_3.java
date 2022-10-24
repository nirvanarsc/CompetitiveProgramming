package leetcode.weekly_contests.weekly_300_399.weekly_316;

import java.util.Arrays;
import java.util.Comparator;

public class P_3 {

    public long minCost(int[] nums, int[] cost) {
        final int n = nums.length;
        final int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i] = new int[] { nums[i], cost[i] };
        }
        Arrays.sort(p, Comparator.comparingInt(v -> v[0]));
        long r = 0;
        long curr = 0;
        for (int[] u : p) {
            r += u[1];
            curr += ((long) u[0] - p[0][0]) * u[1];
        }
        long res = curr;
        long l = p[0][1];
        r -= l;
        for (int i = 1; i < n; i++) {
            final int d = p[i][0] - p[i - 1][0];
            curr += l * d;
            curr -= r * d;
            l += p[i][1];
            r -= p[i][1];
            res = Math.min(res, curr);
        }
        return res;
    }
}
