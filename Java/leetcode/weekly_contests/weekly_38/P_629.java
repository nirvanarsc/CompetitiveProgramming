package leetcode.weekly_contests.weekly_38;

public class P_629 {

    private static final int MOD = (int) (1e9 + 7);

    public int kInversePairsOptimized(int n, int k) {
        int[] dp = new int[1001];
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            final int[] next = new int[1001];
            int sum = 0;
            for (int j = 0; j < next.length; j++) {
                sum = Math.floorMod(sum + dp[j] - (j >= i ? dp[j - i] : 0), MOD);
                next[j] = sum;
                if (next[j] == 0) {
                    break;
                }
            }
            dp = next;
        }
        return dp[k];
    }

    public int kInversePairsPreSum(int n, int k) {
        final int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                if (i <= j) {
                    dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + MOD) % MOD;
                }
            }
        }
        int res = dp[n][k];
        if (k > 0) {
            res = (res - dp[n][k - 1] + MOD) % MOD;
        }
        return res;
    }

    static boolean[][] seen;
    static int[][] dp;

    public int kInversePairs(int n, int k) {
        seen = new boolean[n + 1][k + 1];
        dp = new int[n + 1][k + 1];
        return dfs(n, k);
    }

    private static int dfs(int n, int k) {
        if (k == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (seen[n][k]) {
            return dp[n][k];
        }
        int res = 0;
        for (int i = 0; i < n && i <= k; i++) {
            res = (res + dfs(n - 1, k - i)) % MOD;
        }
        seen[n][k] = true;
        return dp[n][k] = res;
    }
}
