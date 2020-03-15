package weekly_contests.weekly_97;

public class P_887 {

    public int superEggDrop(int k, int n) {
        final int[][] dp = new int[n + 1][k + 1];
        int i = 0;
        while (dp[i][k] < n) {
            i++;
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] + 1;
            }
        }
        return i;
    }

    public int superEggDropSpace(int k, int n) {
        final int[] dp = new int[k + 1];
        int i;
        for (i = 0; dp[k] < n; ++i) {
            for (int j = k; j > 0; --j) {
                dp[j] += dp[j - 1] + 1;
            }
        }
        return i;
    }

    @SuppressWarnings("MethodParameterNamingConvention")
    public int superEggDropTopDown(int K, int N) {
        return recurse(K, N, new Integer[K + 1][N + 1]);
    }

    private static int recurse(int egg, int floor, Integer[][] dp) {
        if (egg == 1 || floor <= 1) {
            return floor;
        }
        if (dp[egg][floor] != null) {
            return dp[egg][floor];
        }
        int res = floor, lo = 1, hi = floor;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            final int left = recurse(egg - 1, mid - 1, dp);
            final int right = recurse(egg, floor - mid, dp);
            if (left <= right) {
                res = Math.min(res, 1 + Math.max(left, right));
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return dp[egg][floor] = res;
    }
}
