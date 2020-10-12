package leetcode.medium;

public class P_375 {

    public int getMoneyAmount(int n) {
        return dfs(1, n, new Integer[n + 1][n + 1]);
    }

    private static int dfs(int lo, int hi, Integer[][] dp) {
        if (lo >= hi) {
            return 0;
        }
        if (dp[lo][hi] != null) {
            return dp[lo][hi];
        }
        int res = Integer.MAX_VALUE;
        final int mid = lo + hi >>> 1;
        for (int i = mid; i <= hi; i++) {
            final int tmp = i + Math.max(dfs(lo, i - 1, dp), dfs(i + 1, hi, dp));
            res = Math.min(res, tmp);
        }
        return dp[lo][hi] = res;
    }
}
