package leetcode.weekly_contests.weekly_192;

public class P_1473 {

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        final int res = dfs(houses, cost, target, 0, -1, new Integer[target][m][n + 1]);
        return res == (int) 1e9 ? -1 : res;
    }

    private static int dfs(int[] houses, int[][] cost, int target, int idx, int prev, Integer[][][] dp) {
        if (idx == houses.length) {
            return target == 0 ? 0 : (int) 1e9;
        }
        if (prev != -1 && dp[target][idx][prev] != null) {
            return dp[target][idx][prev];
        }
        int res = (int) 1e9;
        if (houses[idx] != 0) {
            if (prev == houses[idx]) {
                res = dfs(houses, cost, target, idx + 1, prev, dp);
            } else if (target > 0) {
                res = dfs(houses, cost, target - 1, idx + 1, houses[idx], dp);
            }
        } else {
            for (int j = 0; j < cost[idx].length; j++) {
                if (j + 1 == prev) {
                    res = Math.min(res, cost[idx][j] + dfs(houses, cost, target, idx + 1, prev, dp));
                } else if (target > 0) {
                    res = Math.min(res, cost[idx][j] + dfs(houses, cost, target - 1, idx + 1, j + 1, dp));
                }
            }
        }
        if (prev != -1) {
            dp[target][idx][prev] = res;
        }
        return res;
    }
}
