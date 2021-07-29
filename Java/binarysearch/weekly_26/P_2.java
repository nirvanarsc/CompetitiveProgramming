package binarysearch.weekly_26;

public class P_2 {

    static int total;
    static int maxWins;
    static boolean[][] seen;
    static int[][] dp;

    private static final int MOD = (int) (1e9 + 7);

    public int solve(int n, int k) {
        total = n;
        maxWins = k;
        seen = new boolean[n][k + 1];
        dp = new int[n][k + 1];
        return dfs(0, 0);
    }

    private static int dfs(int idx, int wins) {
        if (idx == total) {
            return 1;
        }
        if (seen[idx][wins]) {
            return dp[idx][wins];
        }
        int res = 0;
        if (wins < maxWins) {
            res = (res + dfs(idx + 1, wins + 1)) % MOD;
        }
        res = (res + dfs(idx + 1, 0)) % MOD;
        seen[idx][wins] = true;
        return dp[idx][wins] = res;
    }
}
