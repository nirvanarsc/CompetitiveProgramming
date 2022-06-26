package leetcode.weekly_contests.weekly_200_299.weekly_299;

public class P_2 {

    private static final int MOD = (int) (1e9 + 7);

    static boolean[][][] seen;
    static int[][][] dp;

    public int countHousePlacements(int n) {
        seen = new boolean[n][2][2];
        dp = new int[n][2][2];
        return dfs(0, n, 0, 0);
    }

    private static int dfs(int idx, int n, int l, int r) {
        if (idx == n) {
            return 1;
        }
        if (seen[idx][l][r]) {
            return dp[idx][l][r];
        }
        int res = dfs(idx + 1, n, 0, 0);
        if (l == 0) {
            res = (res + dfs(idx + 1, n, 1, 0)) % MOD;
        }
        if (r == 0) {
            res = (res + dfs(idx + 1, n, 0, 1)) % MOD;
        }
        if (l == 0 && r == 0) {
            res = (res + dfs(idx + 1, n, 1, 1)) % MOD;
        }
        seen[idx][l][r] = true;
        return dp[idx][l][r] = res;
    }
}
