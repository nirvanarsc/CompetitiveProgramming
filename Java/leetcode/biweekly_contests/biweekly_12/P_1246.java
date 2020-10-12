package leetcode.biweekly_contests.biweekly_12;

public class P_1246 {

    public int minimumMoves(int[] arr) {
        return recurse(0, arr.length - 1, arr, new Integer[arr.length + 1][arr.length + 1]);
    }

    private static int recurse(int i, int j, int[] arr, Integer[][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int res = recurse(i + 1, j, arr, dp) + 1;
        if (arr[i] == arr[i + 1]) {
            res = Math.min(res, recurse(i + 2, j, arr, dp) + 1);
        }
        for (int k = i + 2; k <= j; k++) {
            if (arr[i] == arr[k]) {
                res = Math.min(res, recurse(i + 1, k - 1, arr, dp) + recurse(k + 1, j, arr, dp));
            }
        }
        return dp[i][j] = res;
    }
}
