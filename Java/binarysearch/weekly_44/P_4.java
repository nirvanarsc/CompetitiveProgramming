package binarysearch.weekly_44;

import java.util.Arrays;

public class P_4 {

    static int t;
    static int[][] dp;

    public int solve(String s, int target) {
        t = target;
        dp = new int[s.length()][2000];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(s, 0, 0);
    }

    private static int dfs(String s, int idx, int target) {
        if (idx == s.length()) {
            return Math.abs(t - target);
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }
        int res = (int) 1e5;
        for (int j = 1; j <= 4 && (idx + j) <= s.length(); j++) {
            final int curr = Integer.parseInt(s.substring(idx, idx + j));
            if (target + curr < 2000) {
                res = Math.min(res, dfs(s, idx + j, target + curr));
            }
        }
        return dp[idx][target] = res;
    }
}
