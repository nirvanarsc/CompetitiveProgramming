package leetcode.weekly_contests.weekly_400_499.weekly_453;

public class P_1 {

    public boolean canMakeEqual(int[] nums, int k) {
        final int n = nums.length;
        final int u = f(nums.clone(), n, 1);
        final int v = f(nums.clone(), n, -1);
        return Math.min(u, v) <= k;
    }

    private static int f(int[] nums, int n, int tar) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != tar) {
                if (i == n - 1) {
                    return (int) 1e9;
                }
                nums[i + 1] = -nums[i + 1];
                res++;
            }
        }
        return res;
    }
}
