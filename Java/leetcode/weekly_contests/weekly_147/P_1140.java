package leetcode.weekly_contests.weekly_147;

public class P_1140 {

    public int stoneGameII(int[] piles) {
        final int n = piles.length;
        final int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        return helper(piles, 0, 1, suffixSum, new Integer[n][32]);
    }

    private static int helper(int[] piles, int i, int m, int[] suffixSum, Integer[][] dp) {
        if (i == piles.length) {
            return 0;
        }
        if (2 * m >= piles.length - i) {
            return suffixSum[i];
        }
        if (dp[i][m] != null) {
            return dp[i][m];
        }

        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; x++) {
            min = Math.min(min, helper(piles, i + x, Math.max(m, x), suffixSum, dp));
        }
        return dp[i][m] = suffixSum[i] - min;
    }
}
