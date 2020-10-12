package leetcode.hard;

public class P_312 {

    public int maxCoins(int[] nums) {
        final int[] arr = new int[nums.length + 2];
        arr[0] = arr[arr.length - 1] = 1;
        System.arraycopy(nums, 0, arr, 1, nums.length);
        return recurse(arr, 0, arr.length - 1, new Integer[arr.length][arr.length]);
    }

    private static int recurse(int[] arr, int l, int r, Integer[][] dp) {
        if (l + 1 == r) {
            return 0;
        }
        if (dp[l][r] != null) {
            return dp[l][r];
        }
        int res = Integer.MIN_VALUE;
        for (int i = l + 1; i < r; i++) {
            res = Math.max(res, arr[l] * arr[i] * arr[r] + recurse(arr, l, i, dp) + recurse(arr, i, r, dp));
        }
        return dp[l][r] = res;
    }
}
