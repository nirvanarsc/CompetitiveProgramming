package leetcode.weekly_contests.weekly_100_199.weekly_126;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_1000 {

    public int mergeStones(int[] stones, int K) {
        final int len = stones.length;
        if ((len - 1) % (K - 1) != 0) {
            return -1;
        }

        final int[] prefixSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }

        return dfs(prefixSum, 1, len, 1, K, new Integer[len + 1][len + 1][K + 1]);
    }

    private static int dfs(int[] prefixSum, int left, int right, int piles, int K, Integer[][][] dp) {
        if (left == right) {
            return (piles == 1) ? 0 : (int) 1e9;
        }
        if (piles == 1) {
            return dfs(prefixSum, left, right, K, K, dp) + prefixSum[right] - prefixSum[left - 1];
        }
        if (dp[left][right][piles] != null) {
            return dp[left][right][piles];
        }
        int res = (int) 1e9;
        for (int t = left; t < right; t++) {
            res = Math.min(res, dfs(prefixSum, left, t, piles - 1, K, dp) +
                                dfs(prefixSum, t + 1, right, 1, K, dp));
        }
        return dp[left][right][piles] = res;
    }
}
