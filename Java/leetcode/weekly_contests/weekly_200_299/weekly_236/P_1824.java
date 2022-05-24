package leetcode.weekly_contests.weekly_200_299.weekly_236;

import java.util.Arrays;

public class P_1824 {

    public int minSideJumps(int[] obstacles) {
        final int[][] dp = new int[obstacles.length][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(obstacles, 0, 2, dp);
    }

    private static int dfs(int[] arr, int idx, int level, int[][] dp) {
        if (idx == arr.length - 1) {
            return 0;
        }
        if (dp[idx][level] != -1) {
            return dp[idx][level];
        }
        int res = (int) 1e9;
        for (int i = 1; i <= 3; i++) {
            if (arr[idx + 1] == i || arr[idx] == i) {
                continue;
            }
            final int cost = level != i ? 1 : 0;
            res = Math.min(res, cost + dfs(arr, idx + 1, i, dp));
        }
        return dp[idx][level] = res;
    }
}
