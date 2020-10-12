package leetcode.weekly_contests.weekly_191;

import java.util.Arrays;

public class P_1467 {

    long[][] binom;

    public double getProbability(int[] balls) {
        final int n = Arrays.stream(balls).sum();
        binom = binomialCoeffTable(n, n / 2);
        final long ways = backtrack(0, n / 2, balls, new int[balls.length]);
        return (double) ways / binom[n][n / 2];
    }

    long backtrack(int i, int toPick, int[] balls, int[] picked) {
        if (i == balls.length) {
            if (toPick != 0) {
                return 0L;
            }
            int countA = 0;
            int countB = 0;
            long ways = 1;
            for (int j = 0; j < balls.length; j++) {
                if (picked[j] == 0) {
                    countB++;
                } else if (picked[j] == balls[j]) {
                    countA++;
                }
                ways *= binom[balls[j]][picked[j]];
            }
            return countA == countB ? ways : 0L;
        }
        long ways = 0;
        for (int pick = 0; pick <= Math.min(toPick, balls[i]); pick++) {
            picked[i] = pick;
            ways += backtrack(i + 1, toPick - pick, balls, picked);
        }
        picked[i] = 0;
        return ways;
    }

    public static long[][] binomialCoeffTable(int n, int k) {
        final long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp;
    }
}
