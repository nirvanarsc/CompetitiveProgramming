package easy;

public class P_256 {

    public int minCost(int[][] costs) {
        return recurse(costs, 0, -1, new Integer[costs.length][3]);
    }

    private static int recurse(int[][] costs, int i, int prev, Integer[][] dp) {
        if (i == costs.length) {
            return 0;
        }
        if (prev == -1) {
            return Math.min(costs[0][0] + recurse(costs, i + 1, 0, dp),
                            Math.min(costs[0][1] + recurse(costs, i + 1, 1, dp),
                                     costs[0][2] + recurse(costs, i + 1, 2, dp)));
        }
        if (dp[i][prev] != null) {
            return dp[i][prev];
        }
        switch (prev) {
            case 0:
                return dp[i][prev] = Math.min(costs[i][1] + recurse(costs, i + 1, 1, dp),
                                              costs[i][2] + recurse(costs, i + 1, 2, dp));
            case 1:
                return dp[i][prev] = Math.min(costs[i][0] + recurse(costs, i + 1, 0, dp),
                                              costs[i][2] + recurse(costs, i + 1, 2, dp));
            default:
                return dp[i][prev] = Math.min(costs[i][1] + recurse(costs, i + 1, 1, dp),
                                              costs[i][0] + recurse(costs, i + 1, 0, dp));
        }
    }
}
