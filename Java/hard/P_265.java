package hard;

public class P_265 {

    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        return dfs(costs, 0, -1, new Integer[costs.length][costs[0].length]);
    }

    private static int dfs(int[][] costs, int idx, int prev, Integer[][] dp) {
        if (idx == costs.length) {
            return 0;
        }
        if (prev != -1 && dp[idx][prev] != null) {
            return dp[idx][prev];
        }
        int res = (int) 1e9;
        for (int j = 0; j < costs[idx].length; j++) {
            if (j != prev) {
                res = Math.min(res, costs[idx][j] + dfs(costs, idx + 1, j, dp));
            }
        }
        if (prev != -1) {
            dp[idx][prev] = res;
        }
        return res;
    }
}
