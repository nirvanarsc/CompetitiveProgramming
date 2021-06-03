package leetcode.weekly_contests.weekly_191;

import java.util.Arrays;

public class P_1467 {

    private static class Combinations {
        long[][] dp;

        Combinations(int n) {
            dp = new long[n + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= Math.min(i, n); j++) {
                    if (j == 0 || j == i) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    }
                }
            }
        }

        long nck(int n, int k) {
            return dp[n][k];
        }
    }

    private static Combinations comb;

    public double getProbability(int[] balls) {
        final int n = Arrays.stream(balls).sum();
        comb = new Combinations(n);
        final long ways = dfs(0, n / 2, balls, new int[balls.length]);
        return (double) ways / comb.nck(n, n / 2);
    }

    private static long dfs(int idx, int toPick, int[] balls, int[] picked) {
        if (idx == balls.length) {
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
                ways *= comb.nck(balls[j], picked[j]);
            }
            return countA == countB ? ways : 0L;
        }
        long ways = 0;
        for (int pick = 0; pick <= Math.min(toPick, balls[idx]); pick++) {
            picked[idx] += pick;
            ways += dfs(idx + 1, toPick - pick, balls, picked);
            picked[idx] -= pick;
        }
        return ways;
    }
}
