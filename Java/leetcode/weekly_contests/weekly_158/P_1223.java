package leetcode.weekly_contests.weekly_158;

public class P_1223 {

    private static final int MOD = (int) (1e9 + 7);

    public int dieSimulator(int n, int[] rollMax) {
        return dfs(n, rollMax, 6, 0, new Integer[n + 1][7][16]);
    }

    private static int dfs(int dieLeft, int[] rollMax, int prev, int currLen, Integer[][][] dp) {
        if (dieLeft == 0) {
            return 1;
        }
        if (dp[dieLeft][prev][currLen] != null) {
            return dp[dieLeft][prev][currLen];
        }
        int res = 0;
        for (int i = 0; i < 6; i++) {
            if (i == prev && currLen == rollMax[i]) { continue; }
            res = (res + dfs(dieLeft - 1, rollMax, i, i == prev ? currLen + 1 : 1, dp)) % MOD;
        }
        return dp[dieLeft][prev][currLen] = res;
    }
}
