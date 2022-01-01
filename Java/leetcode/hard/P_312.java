package leetcode.hard;

public class P_312 {

    static boolean[][] seen;
    static int[][] dp;

    public int maxCoins(int[] nums) {
        final int n = nums.length;
        final int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, n);
        seen = new boolean[n + 2][n + 2];
        dp = new int[n + 2][n + 2];
        return dfs(arr, 0, n + 1);
    }

    private static int dfs(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        if (seen[l][r]) {
            return dp[l][r];
        }
        int res = 0;
        for (int k = l + 1; k < r; k++) {
            res = Math.max(res, nums[l] * nums[r] * nums[k] + dfs(nums, l, k) + dfs(nums, k, r));
        }
        seen[l][r] = true;
        return dp[l][r] = res;
    }
}
