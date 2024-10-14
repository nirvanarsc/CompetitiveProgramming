package leetcode.biweekly_contests.biweekly_100_199.biweekly_141;

public class P_3 {

    static int[] cost;
    static boolean[][] seen;
    static int[][] dp;

    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        final int n = source.length();
        cost = new int[n];
        for (int idx : targetIndices) {
            cost[idx] = 1;
        }
        seen = new boolean[n][pattern.length()];
        dp = new int[n][pattern.length()];
        return dfs(0, 0, source.toCharArray(), pattern.toCharArray());
    }

    private static int dfs(int l, int r, char[] source, char[] target) {
        if (l == source.length) {
            return r == target.length ? 0 : (int) 1e9;
        }
        if (seen[l][r]) {
            return dp[l][r];
        }
        int res = (int) 1e9;
        if (source[l] == target[r]) {
            res = Math.min(res, cost[l] + dfs(l + 1, r + 1, source, target));
        }
        res = Math.min(res, dfs(l + 1, r, source, target));
        seen[l][r] = true;
        return dp[l][r] = res;
    }
}
