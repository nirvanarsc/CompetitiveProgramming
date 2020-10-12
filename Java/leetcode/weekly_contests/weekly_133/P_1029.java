package leetcode.weekly_contests.weekly_133;

import java.util.Arrays;
import java.util.Comparator;

public class P_1029 {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> a[0] - a[1]));
        final int n = costs.length / 2;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += costs[i][0] + costs[i + n][1];
        }
        return res;
    }

    public static int twoCitySchedCostBottomUp(int[][] costs) {
        final int n = costs.length / 2;
        final int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        return dp[n][n];
    }

    public int twoCitySchedCostDP(int[][] costs) {
        final int n = costs.length / 2;
        return dfs(costs, 0, 0, 0, new Integer[n + 1][n + 1]);
    }

    private static int dfs(int[][] costs, int idx, int i, int j, Integer[][] dp) {
        if (idx == costs.length) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int takeA = (int) 1e9;
        if (i < costs.length / 2) {
            takeA = costs[idx][0] + dfs(costs, idx + 1, i + 1, j, dp);
        }
        int takeB = (int) 1e9;
        if (j < costs.length / 2) {
            takeB = costs[idx][1] + dfs(costs, idx + 1, i, j + 1, dp);
        }
        return dp[i][j] = Math.min(takeA, takeB);
    }
}
