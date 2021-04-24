package binarysearch.weekly_50;

import java.util.Arrays;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    static int[][] dp;
    static boolean[] banned;

    public int solve(int height, int[] blacklist) {
        dp = new int[2][height + 1];
        banned = new boolean[height + 1];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        for (int num : blacklist) {
            if (num <= height) {
                banned[num] = true;
            }
        }
        return dfs(height, 0);
    }

    private static int dfs(int n, int turn) {
        if (n < 0 || banned[n]) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[turn][n] != -1) {
            return dp[turn][n];
        }
        int res = 0;
        if (turn % 2 == 0) {
            res = (res + dfs(n - 1, 1)) % MOD;
            res = (res + dfs(n - 2, 1)) % MOD;
            res = (res + dfs(n - 4, 1)) % MOD;
        } else {
            res = (res + dfs(n - 1, 0)) % MOD;
            res = (res + dfs(n - 3, 0)) % MOD;
            res = (res + dfs(n - 4, 0)) % MOD;
        }
        return dp[turn][n] = res;
    }
}
