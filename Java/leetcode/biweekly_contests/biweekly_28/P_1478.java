package leetcode.biweekly_contests.biweekly_28;

import java.util.Arrays;

public class P_1478 {

    private static final int MAX = (int) 1e9;

    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        return solve(houses, k, 0, 0, new Integer[houses.length][k]);
    }

    public int solve(int[] houses, int k, int pos, int curK, Integer[][] dp) {
        if (pos == houses.length) {
            return curK == k ? 0 : MAX;
        }
        if (curK == k) {
            return MAX;
        }
        if (dp[pos][curK] != null) {
            return dp[pos][curK];
        }
        int res = MAX;
        for (int i = pos; i < houses.length; i++) {
            final int median = houses[(i + pos) / 2];
            int cost = 0;
            for (int j = pos; j <= i; j++) {
                cost += Math.abs(median - houses[j]);
            }
            res = Math.min(res, solve(houses, k, i + 1, curK + 1, dp) + cost);
        }
        return dp[pos][curK] = res;
    }
}
