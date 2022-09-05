package leetcode.weekly_contests.weekly_300_399.weekly_309;

public class P_2 {

    private static final int MOD = (int) (1e9 + 7);

    static boolean[][] seen;
    static int[][] dp;
    static int end;
    static int offset;

    public int numberOfWays(int startPos, int endPos, int k) {
        if (Math.abs(endPos - startPos) % 2 != k % 2) {
            return 0;
        }
        end = endPos;
        offset = k;
        seen = new boolean[startPos + 2 * k][k + 1];
        dp = new int[startPos + 2 * k][k + 1];
        return dfs(startPos, k);
    }

    private static int dfs(int u, int v) {
        if (v == 0) {
            return u == end ? 1 : 0;
        }
        if (seen[u + offset][v]) {
            return dp[u + offset][v];
        }
        seen[u + offset][v] = true;
        return dp[u + offset][v] = (dfs(u - 1, v - 1) + dfs(u + 1, v - 1)) % MOD;
    }
}
