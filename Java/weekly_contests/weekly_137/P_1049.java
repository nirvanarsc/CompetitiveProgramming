package weekly_contests.weekly_137;

public class P_1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int value : stones) {
            sum += value;
        }
        return recurse(stones, 0, 0, sum, new Integer[stones.length][sum + 1]);
    }

    private static int recurse(int[] stones, int i, int sum, int total, Integer[][] dp) {
        if (i == stones.length) {
            return Math.abs(sum - total);
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        final int diff1 = recurse(stones, i + 1, sum + stones[i], total - stones[i], dp);
        final int diff2 = recurse(stones, i + 1, sum, total, dp);

        return dp[i][sum] = Math.min(diff1, diff2);
    }
}
