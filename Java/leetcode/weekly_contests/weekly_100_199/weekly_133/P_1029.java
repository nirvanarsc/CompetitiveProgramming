package leetcode.weekly_contests.weekly_100_199.weekly_133;

import java.util.Arrays;
import java.util.Comparator;

public class P_1029 {

    public int twoCitySchedCostSort(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> a[0] - a[1]));
        final int n = costs.length / 2;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += costs[i][0] + costs[i + n][1];
        }
        return res;
    }

    public int twoCitySchedCost(int[][] costs) {
        final int n = costs.length;
        final int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 1e9);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + costs[i][1]);
                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + costs[i][0]);
            }
        }
        return dp[n][n / 2];
    }
}
