package weekly_contests.weekly_63;

public class P_746 {

    public int minCostClimbingStairs(int[] cost) {
        final Integer[] dp = new Integer[cost.length];
        return Math.min(dfs(cost, 0, dp), dfs(cost, 1, dp));
    }

    private static int dfs(int[] cost, int i, Integer[] dp) {
        if (i == cost.length) {
            return 0;
        }
        if (i > cost.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int first = dfs(cost, i + 1, dp);
        int second = dfs(cost, i + 2, dp);
        if (first != Integer.MAX_VALUE) {
            first += cost[i];
        }
        if (second != Integer.MAX_VALUE) {
            second += cost[i];
        }
        return dp[i] = Math.min(first, second);
    }
}
