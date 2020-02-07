package hard;

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

    public int superEggDropTopDown(int k, int n) {
        return recurse(k, n, new Integer[k + 1][n + 1]);
    }

    private static int recurse(int k, int n, Integer[][] dp) {
        if (n <= 1) {
            return n;
        }
        if (k == 1) {
            return n;
        }
        if (dp[k][n] != null) {
            return dp[k][n];
        }
        int low = 1, high = n, result = n;
        while (low < high) {
            final int mid = low + high >>> 1;
            final int left = recurse(k - 1, mid - 1, dp);
            final int right = recurse(k, n - mid, dp);
            if (left <= right) {
                result = Math.min(result, Math.max(left, right) + 1);
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return dp[k][n] = result;
    }
}
