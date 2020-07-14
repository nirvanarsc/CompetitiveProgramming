package weekly_contests.weekly_137;

public class P_1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int value : stones) {
            sum += value;
        }
        return recurse(stones, 0, 0, 0, new Integer[stones.length][sum + 1]);
    }

    private static int recurse(int[] stones, int i, int sum1, int sum2, Integer[][] dp) {
        if (i == stones.length) {
            return Math.abs(sum1 - sum2);
        }
        if (dp[i][sum1] != null) {
            return dp[i][sum1];
        }

        final int diff1 = recurse(stones, i + 1, sum1 + stones[i], sum2, dp);
        final int diff2 = recurse(stones, i + 1, sum1, sum2 + stones[i], dp);

        return dp[i][sum1] = Math.min(diff1, diff2);
    }

    public int lastStoneWeightIITopDown(int[] stones) {
        final int n = stones.length;
        int sum = 0;
        for (int value : stones) {
            sum += value;
        }
        final int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - 2 * dp[n][sum / 2];
    }
}
