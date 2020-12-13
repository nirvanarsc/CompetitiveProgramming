package leetcode.hard;

public class P_312 {

    public int maxCoins(int[] nums) {
        final int n = nums.length + 2;
        final int[] arr = new int[n];
        arr[0] = arr[n - 1] = 1;
        System.arraycopy(nums, 0, arr, 1, nums.length);
        return dfs(arr, 0, n - 1, new Integer[n][n]);
    }

    private static int dfs(int[] arr, int i, int j, Integer[][] dp) {
        if (i == j) {
            return 1;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int res = 0;
        for (int k = i + 1; k < j; k++) {
            res = Math.max(res, arr[i] * arr[k] * arr[j] + dfs(arr, i, k, dp) + dfs(arr, k, j, dp));
        }
        return dp[i][j] = res;
    }
}
