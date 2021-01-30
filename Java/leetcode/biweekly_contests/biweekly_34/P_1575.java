package leetcode.biweekly_contests.biweekly_34;

import java.util.Arrays;

public class P_1575 {

    private static final int MOD = (int) (1e9 + 7);

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        final int[][] dp = new int[105][205];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(locations, start, finish, fuel, dp);
    }

    private static int dfs(int[] arr, int i, int j, int fuel, int[][] dp) {
        if (dp[i][fuel] != -1) {
            return dp[i][fuel];
        }
        int res = i == j ? 1 : 0;
        for (int k = 0; k < arr.length; k++) {
            if (k != i) {
                final int cost = Math.abs(arr[i] - arr[k]);
                if (cost <= fuel) {
                    res = (res + dfs(arr, k, j, fuel - cost, dp)) % MOD;
                }
            }
        }
        return dp[i][fuel] = res;
    }
}
