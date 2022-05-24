package leetcode.weekly_contests.weekly_0_99.weekly_12;

import java.util.Arrays;

public class P_475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int lo = 0;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (!canCover(houses, heaters, mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static boolean canCover(int[] houses, int[] heaters, int range) {
        int j = 0;
        for (int i = 0; i < houses.length && j < heaters.length; i++) {
            while (j < heaters.length && range < Math.abs(houses[i] - heaters[j])) {
                j++;
            }
        }
        return j < heaters.length;
    }

    public int findRadiusBF(int[] houses, int[] heaters) {
        int res = Integer.MIN_VALUE;
        final int[] dp = new int[houses.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int heater : heaters) {
            for (int i = 0; i < houses.length; i++) {
                dp[i] = Math.min(dp[i], Math.abs(heater - houses[i]));
            }
        }
        for (int d : dp) {
            res = Math.max(res, d);
        }
        return res;
    }
}
