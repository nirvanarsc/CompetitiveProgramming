package leetcode.biweekly_contests.biweekly_100_199.biweekly_155;

import java.util.Arrays;

public class P_4 {

    public int maxProfit(int n, int[][] edges, int[] score) {
        final int[] need = new int[n];
        for (int[] e : edges) {
            final int u = e[0];
            final int v = e[1];
            need[v] |= 1 << u;
        }
        final int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == -1) {
                continue;
            }
            final int mul = Integer.bitCount(mask) + 1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0 && (mask & need[i]) == need[i]) {
                    dp[mask | (1 << i)] = Math.max(dp[mask | (1 << i)],
                                                   dp[mask] + score[i] * mul);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
