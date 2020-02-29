package weekly_contests.weekly_133;

import java.util.Arrays;
import java.util.Comparator;

public class P_1029 {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> a[0] - a[1]));
        int res = 0;
        for (int i = 0; i < costs.length; i++) {
            res += i < costs.length / 2 ? costs[i][0] : costs[i][1];
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

    public int twoCitySchedCostTopDown(int[][] costs) {
        final int n = costs.length / 2;
        return recurse(costs, 0, n, n, new Integer[n + 1][n + 1]);
    }

    private static int recurse(int[][] c, int i, int a, int b, Integer[][] dp) {
        if (i == c.length) {
            return 0;
        }
        if (dp[a][b] != null) {
            return dp[a][b];
        }
        if (a == 0) {
            return dp[0][b] = c[i][1] + recurse(c, i + 1, 0, b - 1, dp);
        }
        if (b == 0) {
            return dp[a][0] = c[i][0] + recurse(c, i + 1, a - 1, 0, dp);
        }
        return dp[a][b] = Math.min(c[i][0] + recurse(c, i + 1, a - 1, b, dp),
                                   c[i][1] + recurse(c, i + 1, a, b - 1, dp));
    }
}
