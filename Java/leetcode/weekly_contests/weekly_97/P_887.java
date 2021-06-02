package leetcode.weekly_contests.weekly_97;

public class P_887 {

    public int superEggDropTopDown(int k, int n) {
        final int[][] dp = new int[n + 1][k + 1];
        int i;
        for (i = 1; dp[i - 1][k] < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] + 1;
            }
        }
        return i - 1;
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

    static int[][] dp;

    public int superEggDrop(int k, int n) {
        dp = new int[n + 1][k + 1];
        return dfs(n, k);
    }

    private static int dfs(int floors, int eggs) {
        if (eggs == 1 || floors <= 1) {
            return floors;
        }
        if (dp[floors][eggs] > 0) {
            return dp[floors][eggs];
        }
        int res = (int) 1e9;
        int lo = 1;
        int hi = floors;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            final int left = dfs(mid - 1, eggs - 1);
            final int right = dfs(floors - mid, eggs);
            if (left > right) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        res = Math.min(res, 1 + Math.max(dfs(lo - 1, eggs - 1),
                                         dfs(floors - lo, eggs)));
        return dp[floors][eggs] = res;
    }
}
