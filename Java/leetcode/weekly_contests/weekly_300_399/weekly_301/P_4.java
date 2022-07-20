package leetcode.weekly_contests.weekly_300_399.weekly_301;

import java.util.Arrays;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public int idealArrays(int n, int maxValue) {
        final int[][] dp = new int[n + 1][maxValue + 1];
        dp[0][1] = 1;
        final int[] coeff = new int[maxValue + 1];
        for (int prev = 1; prev <= maxValue; prev++) {
            for (int j = prev; j <= maxValue; j += prev) {
                coeff[j]++;
            }
        }
        System.out.println(Arrays.toString(coeff));
        for (int prev = 1; prev <= maxValue; prev++) {
            for (int i = 0; i < n; i++) {
                if (dp[i][prev] == 0) {
                    continue;
                }
                for (int j = prev; j <= maxValue; j += prev) {
                    dp[i + 1][j] = (dp[i + 1][j] + dp[i][prev]) % MOD;
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= maxValue; i++) {
            res = (res + dp[n][i]) % MOD;
        }
        return res;
    }
}
