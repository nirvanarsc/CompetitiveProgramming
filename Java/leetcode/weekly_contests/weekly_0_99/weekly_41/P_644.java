package leetcode.weekly_contests.weekly_0_99.weekly_41;

public class P_644 {

    public double findMaxAverage(int[] nums, int k) {
        double lo = Integer.MAX_VALUE;
        double hi = Integer.MIN_VALUE;
        for (int num : nums) {
            lo = Math.min(lo, num);
            hi = Math.max(hi, num);
        }
        while (hi - lo > 0.00001) {
            final double mid = (lo + hi) * 0.5;
            if (check(nums, k, mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static boolean check(int[] nums, int k, double mid) {
        double sum = 0, prev = 0, minSum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - mid;
        }
        if (sum >= 0) {
            return true;
        }
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prev += nums[i - k] - mid;
            minSum = Math.min(prev, minSum);
            if (sum - minSum >= 0) {
                return true;
            }
        }
        return false;
    }
}
