package leetcode.weekly_contests.weekly_100_199.weekly_166;

public final class P_1283 {

    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 0;
        int hi = (int) 1e6;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (f(nums, mid) > threshold) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo + 1;
    }

    private static long f(int[] nums, int mid) {
        long curr = 0;
        for (int num : nums) {
            curr += (num / mid) + (num % mid != 0 ? 1 : 0);
        }
        return curr;
    }
}
