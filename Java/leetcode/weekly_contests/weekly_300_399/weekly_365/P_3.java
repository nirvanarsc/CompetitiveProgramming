package leetcode.weekly_contests.weekly_300_399.weekly_365;

public class P_3 {

    public int minSizeSubarray(int[] nums, int target) {
        final int n = nums.length;
        long s = 0L;
        for (int num : nums) {
            s += num;
        }
        final int res = (int) ((target / s) * n);
        final int o = f(nums, n, (int) (target % s));
        return o == (int) 1e9 ? -1 : res + o;
    }

    private static int f(int[] arr, int n, int target) {
        int res = (int) 1e9;
        final long[] pre = new long[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            pre[i] = pre[i - 1] + arr[(i - 1 + n) % n];
        }
        for (int i = 0; i < n; i++) {
            final int lo = lowerBound(pre, i, n + i, target);
            if (pre[lo] - pre[i] == target) {
                res = Math.min(res, lo - i);
            }
        }
        return res;
    }

    public static int lowerBound(long[] nums, int from, int to, long target) {
        int lo = from;
        int hi = to;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] - nums[from] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
