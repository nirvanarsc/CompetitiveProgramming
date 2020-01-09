package medium;

public class P_264 {

    public int nthUglyNumber(int n) {
        final int[] dp = new int[n];
        dp[0] = 1;
        int prev2 = 0, prev3 = 0, prev5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[prev2] * 2, Math.min(dp[prev3] * 3, dp[prev5] * 5));
            if (dp[i] == dp[prev2] * 2) { prev2++; }
            if (dp[i] == dp[prev3] * 3) { prev3++; }
            if (dp[i] == dp[prev5] * 5) { prev5++; }
        }
        return dp[n - 1];
    }
}
