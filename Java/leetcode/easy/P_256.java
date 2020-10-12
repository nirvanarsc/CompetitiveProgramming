package leetcode.easy;

public class P_256 {

    public int minCost(int[][] costs) {
        return dfs(costs, 0, -1, new Integer[costs.length][3]);
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
