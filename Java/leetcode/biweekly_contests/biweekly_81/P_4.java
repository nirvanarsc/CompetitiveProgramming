package leetcode.biweekly_contests.biweekly_81;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    static int[][] g = {
            { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 3, 5 }, { 1, 2, 4, 5 }, { 1, 3, 5 },
            { 1, 2, 3, 4, 6 }, { 1, 5 }
    };

    static boolean[][][] seen;
    static int[][][] dp;

    public int distinctSequences(int n) {
        seen = new boolean[n][7][7];
        dp = new int[n][7][7];
        return dfs(0, 0, 0, n);
    }

    private static int dfs(int idx, int prev, int prev2, int n) {
        if (idx == n) {
            return 1;
        }
        if (seen[idx][prev][prev2]) {
            return dp[idx][prev][prev2];
        }
        int res = 0;
        for (int u : g[prev]) {
            if (u != prev && u != prev2) {
                res = (res + dfs(idx + 1, u, prev, n)) % MOD;
            }
        }
        seen[idx][prev][prev2] = true;
        return dp[idx][prev][prev2] = res;
    }
}
