package leetcode.weekly_contests.weekly_284;

public class P_3 {

    public int maximumTop(int[] nums, int k) {
        final int n = nums.length;
        final int[] max = new int[n + 1];
        if (k == 0) {
            return nums[0];
        }
        if (n == 1) {
            return k % 2 == 0 ? nums[0] : -1;
        }
        for (int i = 1; i <= n; i++) {
            max[i] = Math.max(max[i - 1], nums[i - 1]);
        }
        if (k > n) {
            return max[n];
        }
        if (k == n) {
            return max[n - 1];
        }
        return Math.max(max[k - 1], nums[k]);
    }
}
