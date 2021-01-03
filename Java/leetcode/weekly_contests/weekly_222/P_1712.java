package leetcode.weekly_contests.weekly_222;

public class P_1712 {

    private static final int MOD = (int) 1e9 + 7;

    public int waysToSplit(int[] nums) {
        final int n = nums.length;
        final int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            final int left = pre[i + 1];
            final int j = lowerBound(pre, 2 * left, i + 2);
            final int max = (pre[n] - left) / 2;
            final int k = lowerBound(pre, left + max + 1, i + 2);
            final int add = Math.max(0, k - j);
            res = (res + add) % MOD;
        }
        return res;
    }

    private static int lowerBound(int[] nums, int target, int lo) {
        int hi = nums.length - 1;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
