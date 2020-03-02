package weekly_contests.weekly_126;

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

        return getResult(prefixSum, 1, len, 1, K, new Integer[len + 1][len + 1][K + 1]);
    }

    private static int getResult(int[] prefixSum, int left, int right, int piles, int K, Integer[][][] dp) {
        if (left == right) {
            return (piles == 1) ? 0 : Integer.MAX_VALUE;
        }
        if (dp[left][right][piles] != null) {
            return dp[left][right][piles];
        }

        int res = Integer.MAX_VALUE;
        if (piles == 1) {
            final int mergeK = getResult(prefixSum, left, right, K, K, dp);
            if (mergeK != Integer.MAX_VALUE) {
                res = mergeK + prefixSum[right] - prefixSum[left - 1];
            }
        } else {
            for (int t = left; t < right; t++) {
                final int l = getResult(prefixSum, left, t, piles - 1, K, dp);
                final int r = getResult(prefixSum, t + 1, right, 1, K, dp);
                if (l != Integer.MAX_VALUE && r != Integer.MAX_VALUE) {
                    res = Math.min(res, l + r);
                }
            }
        }

        return dp[left][right][piles] = res;
    }
}
